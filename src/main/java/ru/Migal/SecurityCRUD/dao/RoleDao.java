package ru.Migal.SecurityCRUD.dao;


import ru.Migal.SecurityCRUD.model.Role;

import java.util.List;

public interface RoleDao {
    void addRole(Role role);

    void updateRole(Role role);

    void removeRoleById(Role role);

    Role getRoleByName(String role);

    List<Role> getAllRoles();
}
