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
public class Role implements Serializable {

    private static final long serialVersionUID = 1563454674189L;


    /**
    * 主键
    * 主键
    * isNullAble:0
    */
    private Integer id;

    /**
    * 角色
    * isNullAble:1
    */
    private String role;

    /**
    * 角色描述
    * isNullAble:1
    */
    private String description;


    public void setId(Integer id){this.id = id;}

    public Integer getId(){return this.id;}

    public void setRole(String role){this.role = role;}

    public String getRole(){return this.role;}

    public void setDescription(String description){this.description = description;}

    public String getDescription(){return this.description;}
    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                "role='" + role + '\'' +
                "description='" + description + '\'' +
            '}';
    }

    public static Builder Build(){return new Builder();}

    public static ConditionBuilder ConditionBuild(){return new ConditionBuilder();}

    public static UpdateBuilder UpdateBuild(){return new UpdateBuilder();}

    public static QueryBuilder QueryBuild(){return new QueryBuilder();}

    public static class UpdateBuilder {

        private Role set;

        private ConditionBuilder where;

        public UpdateBuilder set(Role set){
            this.set = set;
            return this;
        }

        public Role getSet(){
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

    public static class QueryBuilder extends Role{
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

        private List<String> roleList;

        public List<String> getRoleList(){return this.roleList;}


        private List<String> fuzzyRole;

        public List<String> getFuzzyRole(){return this.fuzzyRole;}

        private List<String> rightFuzzyRole;

        public List<String> getRightFuzzyRole(){return this.rightFuzzyRole;}
        private List<String> descriptionList;

        public List<String> getDescriptionList(){return this.descriptionList;}


        private List<String> fuzzyDescription;

        public List<String> getFuzzyDescription(){return this.fuzzyDescription;}

        private List<String> rightFuzzyDescription;

        public List<String> getRightFuzzyDescription(){return this.rightFuzzyDescription;}
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

        public QueryBuilder fuzzyRole (List<String> fuzzyRole){
            this.fuzzyRole = fuzzyRole;
            return this;
        }

        public QueryBuilder fuzzyRole (String ... fuzzyRole){
            this.fuzzyRole = solveNullList(fuzzyRole);
            return this;
        }

        public QueryBuilder rightFuzzyRole (List<String> rightFuzzyRole){
            this.rightFuzzyRole = rightFuzzyRole;
            return this;
        }

        public QueryBuilder rightFuzzyRole (String ... rightFuzzyRole){
            this.rightFuzzyRole = solveNullList(rightFuzzyRole);
            return this;
        }

        public QueryBuilder role(String role){
            setRole(role);
            return this;
        }

        public QueryBuilder roleList(String ... role){
            this.roleList = solveNullList(role);
            return this;
        }

        public QueryBuilder roleList(List<String> role){
            this.roleList = role;
            return this;
        }

        public QueryBuilder fetchRole(){
            setFetchFields("fetchFields","role");
            return this;
        }

        public QueryBuilder excludeRole(){
            setFetchFields("excludeFields","role");
            return this;
        }

        public QueryBuilder fuzzyDescription (List<String> fuzzyDescription){
            this.fuzzyDescription = fuzzyDescription;
            return this;
        }

        public QueryBuilder fuzzyDescription (String ... fuzzyDescription){
            this.fuzzyDescription = solveNullList(fuzzyDescription);
            return this;
        }

        public QueryBuilder rightFuzzyDescription (List<String> rightFuzzyDescription){
            this.rightFuzzyDescription = rightFuzzyDescription;
            return this;
        }

        public QueryBuilder rightFuzzyDescription (String ... rightFuzzyDescription){
            this.rightFuzzyDescription = solveNullList(rightFuzzyDescription);
            return this;
        }

        public QueryBuilder description(String description){
            setDescription(description);
            return this;
        }

        public QueryBuilder descriptionList(String ... description){
            this.descriptionList = solveNullList(description);
            return this;
        }

        public QueryBuilder descriptionList(List<String> description){
            this.descriptionList = description;
            return this;
        }

        public QueryBuilder fetchDescription(){
            setFetchFields("fetchFields","description");
            return this;
        }

        public QueryBuilder excludeDescription(){
            setFetchFields("excludeFields","description");
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

        public Role build(){return this;}
    }


    public static class ConditionBuilder{
        private List<Integer> idList;

        public List<Integer> getIdList(){return this.idList;}

        private Integer idSt;

        private Integer idEd;

        public Integer getIdSt(){return this.idSt;}

        public Integer getIdEd(){return this.idEd;}

        private List<String> roleList;

        public List<String> getRoleList(){return this.roleList;}


        private List<String> fuzzyRole;

        public List<String> getFuzzyRole(){return this.fuzzyRole;}

        private List<String> rightFuzzyRole;

        public List<String> getRightFuzzyRole(){return this.rightFuzzyRole;}
        private List<String> descriptionList;

        public List<String> getDescriptionList(){return this.descriptionList;}


        private List<String> fuzzyDescription;

        public List<String> getFuzzyDescription(){return this.fuzzyDescription;}

        private List<String> rightFuzzyDescription;

        public List<String> getRightFuzzyDescription(){return this.rightFuzzyDescription;}

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

        public ConditionBuilder fuzzyRole (List<String> fuzzyRole){
            this.fuzzyRole = fuzzyRole;
            return this;
        }

        public ConditionBuilder fuzzyRole (String ... fuzzyRole){
            this.fuzzyRole = solveNullList(fuzzyRole);
            return this;
        }

        public ConditionBuilder rightFuzzyRole (List<String> rightFuzzyRole){
            this.rightFuzzyRole = rightFuzzyRole;
            return this;
        }

        public ConditionBuilder rightFuzzyRole (String ... rightFuzzyRole){
            this.rightFuzzyRole = solveNullList(rightFuzzyRole);
            return this;
        }

        public ConditionBuilder roleList(String ... role){
            this.roleList = solveNullList(role);
            return this;
        }

        public ConditionBuilder roleList(List<String> role){
            this.roleList = role;
            return this;
        }

        public ConditionBuilder fuzzyDescription (List<String> fuzzyDescription){
            this.fuzzyDescription = fuzzyDescription;
            return this;
        }

        public ConditionBuilder fuzzyDescription (String ... fuzzyDescription){
            this.fuzzyDescription = solveNullList(fuzzyDescription);
            return this;
        }

        public ConditionBuilder rightFuzzyDescription (List<String> rightFuzzyDescription){
            this.rightFuzzyDescription = rightFuzzyDescription;
            return this;
        }

        public ConditionBuilder rightFuzzyDescription (String ... rightFuzzyDescription){
            this.rightFuzzyDescription = solveNullList(rightFuzzyDescription);
            return this;
        }

        public ConditionBuilder descriptionList(String ... description){
            this.descriptionList = solveNullList(description);
            return this;
        }

        public ConditionBuilder descriptionList(List<String> description){
            this.descriptionList = description;
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

        private Role obj;

        public Builder(){
            this.obj = new Role();
        }

        public Builder id(Integer id){
            this.obj.setId(id);
            return this;
        }
        public Builder role(String role){
            this.obj.setRole(role);
            return this;
        }
        public Builder description(String description){
            this.obj.setDescription(description);
            return this;
        }
        public Role build(){return obj;}
    }


}
