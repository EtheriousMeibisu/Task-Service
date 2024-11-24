package com.lyd.TodoTMS.TodoTMS.enums;

import org.springframework.security.core.GrantedAuthority;


//приоритет (например, "высокий", "средний", "низкий")
public enum TaskPriority implements GrantedAuthority {
    HIGH, MEDIUM, LOW;

    @Override
    public String getAuthority() {
        return name();
    }



}
