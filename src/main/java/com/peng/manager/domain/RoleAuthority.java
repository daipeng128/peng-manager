package com.peng.manager.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
/**
*
*  @author author
*/
public class RoleAuthority implements Serializable {

    private static final long serialVersionUID = 1563930253156L;


    /**
    * 主键
    * 
    * isNullAble:0
    */
    private Integer id;

    /**
    * 
    * isNullAble:1
    */
    private Integer roleId;

    /**
    * 
    * isNullAble:1
    */
    private Integer authId;

    private Integer yn;


    public void setId(Integer id){this.id = id;}

    public Integer getId(){return this.id;}

    public void setRoleId(Integer roleId){this.roleId = roleId;}

    public Integer getRoleId(){return this.roleId;}

    public void setAuthId(Integer authId){this.authId = authId;}

    public Integer getAuthId(){return this.authId;}
    @Override
    public String toString() {
        return "RoleAuthority{" +
                "id='" + id + '\'' +
                "roleId='" + roleId + '\'' +
                "authId='" + authId + '\'' +
            '}';
    }

    public static Builder Build(){return new Builder();}

    public static ConditionBuilder ConditionBuild(){return new ConditionBuilder();}

    public static UpdateBuilder UpdateBuild(){return new UpdateBuilder();}

    public static QueryBuilder QueryBuild(){return new QueryBuilder();}

    public static class UpdateBuilder {

        private RoleAuthority set;

        private ConditionBuilder where;

        public UpdateBuilder set(RoleAuthority set){
            this.set = set;
            return this;
        }

        public RoleAuthority getSet(){
            return this.set;
        }

        public UpdateBuilder where(ConditionBuilder where){
            this.where = where;
            return this;
        }

        public ConditionBuilder getWhere(){
            return this.where;
        }

        public UpdateBuilder build(){
            return this;
        }
    }

    public static class QueryBuilder extends RoleAuthority{
        /**
        * 需要返回的列
        */
        private Map<String,Object> fetchFields;

        public Map<String,Object> getFetchFields(){return this.fetchFields;}

        private List<Integer> idList;

        public List<Integer> getIdList(){return this.idList;}

        private Integer idSt;

        private Integer idEd;

        public Integer getIdSt(){return this.idSt;}

        public Integer getIdEd(){return this.idEd;}

        private List<Integer> roleIdList;

        public List<Integer> getRoleIdList(){return this.roleIdList;}

        private Integer roleIdSt;

        private Integer roleIdEd;

        public Integer getRoleIdSt(){return this.roleIdSt;}

        public Integer getRoleIdEd(){return this.roleIdEd;}

        private List<Integer> authIdList;

        public List<Integer> getAuthIdList(){return this.authIdList;}

        private Integer authIdSt;

        private Integer authIdEd;

        public Integer getAuthIdSt(){return this.authIdSt;}

        public Integer getAuthIdEd(){return this.authIdEd;}

        private QueryBuilder (){
            this.fetchFields = new HashMap<>();
        }

        public QueryBuilder idBetWeen(Integer idSt,Integer idEd){
            this.idSt = idSt;
            this.idEd = idEd;
            return this;
        }

        public QueryBuilder idGreaterEqThan(Integer idSt){
            this.idSt = idSt;
            return this;
        }
        public QueryBuilder idLessEqThan(Integer idEd){
            this.idEd = idEd;
            return this;
        }


        public QueryBuilder id(Integer id){
            setId(id);
            return this;
        }

        public QueryBuilder idList(Integer ... id){
            this.idList = solveNullList(id);
            return this;
        }

        public QueryBuilder idList(List<Integer> id){
            this.idList = id;
            return this;
        }

        public QueryBuilder fetchId(){
            setFetchFields("fetchFields","id");
            return this;
        }

        public QueryBuilder excludeId(){
            setFetchFields("excludeFields","id");
            return this;
        }

        public QueryBuilder roleIdBetWeen(Integer roleIdSt,Integer roleIdEd){
            this.roleIdSt = roleIdSt;
            this.roleIdEd = roleIdEd;
            return this;
        }

        public QueryBuilder roleIdGreaterEqThan(Integer roleIdSt){
            this.roleIdSt = roleIdSt;
            return this;
        }
        public QueryBuilder roleIdLessEqThan(Integer roleIdEd){
            this.roleIdEd = roleIdEd;
            return this;
        }


        public QueryBuilder roleId(Integer roleId){
            setRoleId(roleId);
            return this;
        }

        public QueryBuilder roleIdList(Integer ... roleId){
            this.roleIdList = solveNullList(roleId);
            return this;
        }

        public QueryBuilder roleIdList(List<Integer> roleId){
            this.roleIdList = roleId;
            return this;
        }

        public QueryBuilder fetchRoleId(){
            setFetchFields("fetchFields","roleId");
            return this;
        }

        public QueryBuilder excludeRoleId(){
            setFetchFields("excludeFields","roleId");
            return this;
        }

        public QueryBuilder authIdBetWeen(Integer authIdSt,Integer authIdEd){
            this.authIdSt = authIdSt;
            this.authIdEd = authIdEd;
            return this;
        }

        public QueryBuilder authIdGreaterEqThan(Integer authIdSt){
            this.authIdSt = authIdSt;
            return this;
        }
        public QueryBuilder authIdLessEqThan(Integer authIdEd){
            this.authIdEd = authIdEd;
            return this;
        }


        public QueryBuilder authId(Integer authId){
            setAuthId(authId);
            return this;
        }

        public QueryBuilder authIdList(Integer ... authId){
            this.authIdList = solveNullList(authId);
            return this;
        }

        public QueryBuilder authIdList(List<Integer> authId){
            this.authIdList = authId;
            return this;
        }

        public QueryBuilder fetchAuthId(){
            setFetchFields("fetchFields","authId");
            return this;
        }

        public QueryBuilder excludeAuthId(){
            setFetchFields("excludeFields","authId");
            return this;
        }
        private <T>List<T> solveNullList(T ... objs){
            if (objs != null){
            List<T> list = new ArrayList<>();
                for (T item : objs){
                    if (item != null){
                        list.add(item);
                    }
                }
                return list;
            }
            return null;
        }

        public QueryBuilder fetchAll(){
            this.fetchFields.put("AllFields",true);
            return this;
        }

        public QueryBuilder addField(String ... fields){
            List<String> list = new ArrayList<>();
            if (fields != null){
                for (String field : fields){
                    list.add(field);
                }
            }
            this.fetchFields.put("otherFields",list);
            return this;
        }
        @SuppressWarnings("unchecked")
        private void setFetchFields(String key,String val){
            Map<String,Boolean> fields= (Map<String, Boolean>) this.fetchFields.get(key);
            if (fields == null){
                fields = new HashMap<>();
            }
            fields.put(val,true);
            this.fetchFields.put(key,fields);
        }

        public RoleAuthority build(){return this;}
    }


    public static class ConditionBuilder{
        private List<Integer> idList;

        public List<Integer> getIdList(){return this.idList;}

        private Integer idSt;

        private Integer idEd;

        public Integer getIdSt(){return this.idSt;}

        public Integer getIdEd(){return this.idEd;}

        private List<Integer> roleIdList;

        public List<Integer> getRoleIdList(){return this.roleIdList;}

        private Integer roleIdSt;

        private Integer roleIdEd;

        public Integer getRoleIdSt(){return this.roleIdSt;}

        public Integer getRoleIdEd(){return this.roleIdEd;}

        private List<Integer> authIdList;

        public List<Integer> getAuthIdList(){return this.authIdList;}

        private Integer authIdSt;

        private Integer authIdEd;

        public Integer getAuthIdSt(){return this.authIdSt;}

        public Integer getAuthIdEd(){return this.authIdEd;}


        public ConditionBuilder idBetWeen(Integer idSt,Integer idEd){
            this.idSt = idSt;
            this.idEd = idEd;
            return this;
        }

        public ConditionBuilder idGreaterEqThan(Integer idSt){
            this.idSt = idSt;
            return this;
        }
        public ConditionBuilder idLessEqThan(Integer idEd){
            this.idEd = idEd;
            return this;
        }


        public ConditionBuilder idList(Integer ... id){
            this.idList = solveNullList(id);
            return this;
        }

        public ConditionBuilder idList(List<Integer> id){
            this.idList = id;
            return this;
        }

        public ConditionBuilder roleIdBetWeen(Integer roleIdSt,Integer roleIdEd){
            this.roleIdSt = roleIdSt;
            this.roleIdEd = roleIdEd;
            return this;
        }

        public ConditionBuilder roleIdGreaterEqThan(Integer roleIdSt){
            this.roleIdSt = roleIdSt;
            return this;
        }
        public ConditionBuilder roleIdLessEqThan(Integer roleIdEd){
            this.roleIdEd = roleIdEd;
            return this;
        }


        public ConditionBuilder roleIdList(Integer ... roleId){
            this.roleIdList = solveNullList(roleId);
            return this;
        }

        public ConditionBuilder roleIdList(List<Integer> roleId){
            this.roleIdList = roleId;
            return this;
        }

        public ConditionBuilder authIdBetWeen(Integer authIdSt,Integer authIdEd){
            this.authIdSt = authIdSt;
            this.authIdEd = authIdEd;
            return this;
        }

        public ConditionBuilder authIdGreaterEqThan(Integer authIdSt){
            this.authIdSt = authIdSt;
            return this;
        }
        public ConditionBuilder authIdLessEqThan(Integer authIdEd){
            this.authIdEd = authIdEd;
            return this;
        }


        public ConditionBuilder authIdList(Integer ... authId){
            this.authIdList = solveNullList(authId);
            return this;
        }

        public ConditionBuilder authIdList(List<Integer> authId){
            this.authIdList = authId;
            return this;
        }

        private <T>List<T> solveNullList(T ... objs){
            if (objs != null){
            List<T> list = new ArrayList<>();
                for (T item : objs){
                    if (item != null){
                        list.add(item);
                    }
                }
                return list;
            }
            return null;
        }

        public ConditionBuilder build(){return this;}
    }

    public static class Builder {

        private RoleAuthority obj;

        public Builder(){
            this.obj = new RoleAuthority();
        }

        public Builder id(Integer id){
            this.obj.setId(id);
            return this;
        }
        public Builder roleId(Integer roleId){
            this.obj.setRoleId(roleId);
            return this;
        }
        public Builder authId(Integer authId){
            this.obj.setAuthId(authId);
            return this;
        }
        public RoleAuthority build(){return obj;}
    }


    public Integer getYn() {
        return yn;
    }

    public void setYn(Integer yn) {
        this.yn = yn;
    }
}
