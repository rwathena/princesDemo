package com.rwathena.prince.security;


import com.rwathena.prince.user.TSysUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * security用户
 *
 * @author WangHQ
 * @date 2017-08-21 14:39
 */
public class SecurityUser extends User {

    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

    //用户
    private TSysUser sysUserDTO;

    /**
     * 构造方法
     * @param username
     * @param password
     * @param authorities
     * @param sysUserDTO
     */
    public SecurityUser(String username, String password, Collection<? extends GrantedAuthority> authorities, TSysUser sysUserDTO){
        super(username,password,authorities);
        this.sysUserDTO = sysUserDTO;
    }

    public TSysUser getSysUserDTO() {
        return sysUserDTO;
    }

    public void setSysUserDTO(TSysUser sysUserDTO) {
        this.sysUserDTO = sysUserDTO;
    }
}
