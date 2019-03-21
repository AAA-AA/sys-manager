package com.github.sys.convert;

import com.github.sys.domain.user.UserAdd;
import com.github.sys.domain.user.UserUpdate;
import com.github.sys.domain.user.UserVo;
import com.github.sys.model.SecUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by renhongqiang on 2019-03-16 21:30
 */
@Service
public class UserConverter {

    public List<UserVo> toVo(List<SecUser> userList) {
        if (userList == null) {
            return null;
        } else {
            List<UserVo> list = new ArrayList(userList.size());
            Iterator var3 = userList.iterator();

            while(var3.hasNext()) {
                SecUser secUser = (SecUser)var3.next();
                list.add(this.toVo(secUser));
            }

            return list;
        }
    }

    public SecUser fromAdd(UserAdd userAdd) {
        if (userAdd == null) {
            return null;
        } else {
            SecUser secUser = new SecUser();
            secUser.setName(userAdd.getName());
            secUser.setMail(userAdd.getMail());
            secUser.setPassword(userAdd.getPassword());
            secUser.setBirth(userAdd.getBirth().atStartOfDay());
            secUser.setAddress(userAdd.getAddress());
            secUser.setSex(userAdd.getSex());
            secUser.setAge(userAdd.getAge());
            return secUser;
        }
    }

    public SecUser fromUpdate(UserUpdate update) {
        if (update == null) {
            return null;
        } else {
            SecUser secUser = new SecUser();
            secUser.setId(update.getId());
            secUser.setName(update.getName());
            secUser.setMail(update.getMail());
            secUser.setPassword(update.getPassword());
            secUser.setSex(update.getSex());
            secUser.setAge(update.getAge());
            secUser.setAddress(update.getAddress());
            secUser.setBirth(update.getBirth().atStartOfDay());
            return secUser;
        }
    }

    public UserVo toVo(SecUser user) {
        if (user == null) {
            return null;
        } else {
            UserVo userVo = new UserVo();
            userVo.setId(user.getId());
            userVo.setName(user.getName());
            userVo.setMail(user.getMail());
            userVo.setPassword(user.getPassword());
            userVo.setSex(user.getSex());
            userVo.setAge(user.getAge());
            userVo.setBirth(user.getBirth());
            userVo.setAddress(user.getAddress());
            userVo.setStatus(user.getStatus());
            userVo.setCreateTime(user.getCreateTime());
            userVo.setUpdateTime(user.getUpdateTime());
            return userVo;
        }
    }
}
