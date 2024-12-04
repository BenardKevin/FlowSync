package com.ib.flowsync.component;

import com.ib.flowsync.entity.Privilege;
import com.ib.flowsync.entity.Role;
import com.ib.flowsync.entity.User;
import com.ib.flowsync.repository.PrivilegeRepository;
import com.ib.flowsync.repository.RoleRepository;
import com.ib.flowsync.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = true;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup)
            return;

        Privilege createPrivilege = createPrivilegeIfNotFound("CREATE_PRIVILEGE");
        Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privilege updatePrivilege = createPrivilegeIfNotFound("UPDATE_PRIVILEGE");
        Privilege deletePrivilege = createPrivilegeIfNotFound("DELETE_PRIVILEGE");

        List<Privilege> adminPrivileges = Arrays.asList(
                createPrivilege, readPrivilege, updatePrivilege, deletePrivilege);
        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", List.of(readPrivilege));

        Role adminRole = roleRepository.findByName("ROLE_ADMIN").orElseThrow();
        User user = new User();
        user.setFirstname("admin");
        user.setLastname("admin");
        user.setPassword(passwordEncoder.encode("admin"));
        user.setEmail("admin@admin.com");
        user.setRoles(Set.of(adminRole));
        user.setEnabled(true);
        userRepository.save(user);

        alreadySetup = true;
    }

    @Transactional
    public Privilege createPrivilegeIfNotFound(String name) {

        Optional<Privilege> optionalPrivilege = privilegeRepository.findByName(name);

        if (optionalPrivilege.isEmpty()) {
            Privilege privilege = new Privilege(name);
            privilegeRepository.save(privilege);

            return privilege;
        }

        return optionalPrivilege.get();
    }

    @Transactional
    public Role createRoleIfNotFound(String name, Collection<Privilege> privileges) {

        Optional<Role> optionalRole = roleRepository.findByName(name);

        if (optionalRole.isEmpty()) {
            Role role = role = new Role(name);
            role.setPrivileges(privileges.stream().collect(Collectors.toSet()));
            roleRepository.save(role);

            return role;
        }

        return optionalRole.get();
    }
}
