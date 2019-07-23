package com.peng.manager.service.impl;

import com.peng.manager.domain.AuthoriytTree;
import com.peng.manager.mapper.AuthorityMapper;
import com.peng.manager.mapper.AuthorityBaseMapper;
import com.peng.manager.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import packageModel.Authority;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: daipeng
 * @Date: 2019/7/20 16:24
 * @Description:
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityMapper authorityMapper;
    @Autowired
    private AuthorityBaseMapper authorityBaseMapper;


    @Override
    public List<AuthoriytTree> queryAuthorityTree() {

        //查询所有有效的权限
        List<Authority> authorityList = authorityBaseMapper.queryAuthority(new Authority(0));

        List<AuthoriytTree> authoriytTreeList = buildTree(authorityList, 0);
        //递归调用拼装权限树

        return authoriytTreeList;
    }


    /**
     * 递归调用
     * @param authorityList
     * @param parentId
     * @return
     */
    public static List<AuthoriytTree> buildTree(List<Authority> authorityList,int parentId){

        List<AuthoriytTree> authoriytTreeList = new ArrayList<>();

        for (Authority authority : authorityList) {
           int id = authority.getId();
            int pid = authority.getParentId();
            AuthoriytTree tree = new AuthoriytTree(id,authority.getName());

            if (parentId == pid) {
               List<AuthoriytTree> menuLists = buildTree(authorityList, id);
               tree.setChildren(menuLists);
               authoriytTreeList.add(tree);
           }
        }

         return authoriytTreeList;
     }




}
