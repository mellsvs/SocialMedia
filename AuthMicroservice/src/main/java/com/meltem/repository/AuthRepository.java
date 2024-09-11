package com.meltem.repository;

import com.meltem.entity.Auth;

public interface AuthRepository extends MyGenericRepo<Auth, Long> {

    Boolean existsByUserNameAndPassword(String userName, String password);
}
