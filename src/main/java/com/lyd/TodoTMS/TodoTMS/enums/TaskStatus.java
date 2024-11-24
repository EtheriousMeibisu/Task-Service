package com.lyd.TodoTMS.TodoTMS.enums;

import org.springframework.security.core.GrantedAuthority;

public enum TaskStatus implements GrantedAuthority {
    PENDING, IN_PROGRESS, COMPLETED;

    @Override
    public String getAuthority() {
        return name();
    }
    //статус (например, "в ожидании", "в процессе", "завершено")


}
