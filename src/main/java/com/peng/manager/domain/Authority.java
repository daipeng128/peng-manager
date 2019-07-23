package packageModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
/**
*
*  @author author
*/
public class Authority implements Serializable {

    private static final long serialVersionUID = 1563603863870L;


    /**
    * 主键
    * 主键
    * isNullAble:0
    */
    private Integer id;

    /**
    * 权限名称
    * isNullAble:1
    */
    private String name;

    /**
    * 父级id
    * isNullAble:1
    */
    private Integer parentId;

    /**
    * 权限字符串
    * isNullAble:1
    */
    private String permission;

    /**
    * 权限类型 menu button
    * isNullAble:1
    */
    private String authorityType;

    /**
    * 权限地址
    * isNullAble:1
    */
    private String url;

    /**
    * 权限状态 0 启用 1 禁用
    * isNullAble:1
    */
    private Integer yn;


    public void setId(Integer id){this.id = id;}

    public Integer getId(){return this.id;}

    public void setName(String name){this.name = name;}

    public String getName(){return this.name;}

    public void setParentId(Integer parentId){this.parentId = parentId;}

    public Integer getParentId(){return this.parentId;}

    public void setPermission(String permission){this.permission = permission;}

    public String getPermission(){return this.permission;}

    public void setAuthorityType(String authorityType){this.authorityType = authorityType;}

    public String getAuthorityType(){return this.authorityType;}

    public void setUrl(String url){this.url = url;}

    public String getUrl(){return this.url;}

    public void setYn(Integer yn){this.yn = yn;}

    public Integer getYn(){return this.yn;}
    @Override
    public String toString() {
        return "Authority{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                "parentId='" + parentId + '\'' +
                "permission='" + permission + '\'' +
                "authorityType='" + authorityType + '\'' +
                "url='" + url + '\'' +
                "yn='" + yn + '\'' +
            '}';
    }

    public static Builder Build(){return new Builder();}

    public static ConditionBuilder ConditionBuild(){return new ConditionBuilder();}

    public static UpdateBuilder UpdateBuild(){return new UpdateBuilder();}

    public static QueryBuilder QueryBuild(){return new QueryBuilder();}

    public static class UpdateBuilder {

        private Authority set;

        private ConditionBuilder where;

        public UpdateBuilder set(Authority set){
            this.set = set;
            return this;
        }

        public Authority getSet(){
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

    public static class QueryBuilder extends Authority{
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

        private List<String> nameList;

        public List<String> getNameList(){return this.nameList;}


        private List<String> fuzzyName;

        public List<String> getFuzzyName(){return this.fuzzyName;}

        private List<String> rightFuzzyName;

        public List<String> getRightFuzzyName(){return this.rightFuzzyName;}
        private List<Integer> parentIdList;

        public List<Integer> getParentIdList(){return this.parentIdList;}

        private Integer parentIdSt;

        private Integer parentIdEd;

        public Integer getParentIdSt(){return this.parentIdSt;}

        public Integer getParentIdEd(){return this.parentIdEd;}

        private List<String> permissionList;

        public List<String> getPermissionList(){return this.permissionList;}


        private List<String> fuzzyPermission;

        public List<String> getFuzzyPermission(){return this.fuzzyPermission;}

        private List<String> rightFuzzyPermission;

        public List<String> getRightFuzzyPermission(){return this.rightFuzzyPermission;}
        private List<String> authorityTypeList;

        public List<String> getAuthorityTypeList(){return this.authorityTypeList;}


        private List<String> fuzzyAuthorityType;

        public List<String> getFuzzyAuthorityType(){return this.fuzzyAuthorityType;}

        private List<String> rightFuzzyAuthorityType;

        public List<String> getRightFuzzyAuthorityType(){return this.rightFuzzyAuthorityType;}
        private List<String> urlList;

        public List<String> getUrlList(){return this.urlList;}


        private List<String> fuzzyUrl;

        public List<String> getFuzzyUrl(){return this.fuzzyUrl;}

        private List<String> rightFuzzyUrl;

        public List<String> getRightFuzzyUrl(){return this.rightFuzzyUrl;}
        private List<Integer> ynList;

        public List<Integer> getYnList(){return this.ynList;}

        private Integer ynSt;

        private Integer ynEd;

        public Integer getYnSt(){return this.ynSt;}

        public Integer getYnEd(){return this.ynEd;}

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

        public QueryBuilder fuzzyName (List<String> fuzzyName){
            this.fuzzyName = fuzzyName;
            return this;
        }

        public QueryBuilder fuzzyName (String ... fuzzyName){
            this.fuzzyName = solveNullList(fuzzyName);
            return this;
        }

        public QueryBuilder rightFuzzyName (List<String> rightFuzzyName){
            this.rightFuzzyName = rightFuzzyName;
            return this;
        }

        public QueryBuilder rightFuzzyName (String ... rightFuzzyName){
            this.rightFuzzyName = solveNullList(rightFuzzyName);
            return this;
        }

        public QueryBuilder name(String name){
            setName(name);
            return this;
        }

        public QueryBuilder nameList(String ... name){
            this.nameList = solveNullList(name);
            return this;
        }

        public QueryBuilder nameList(List<String> name){
            this.nameList = name;
            return this;
        }

        public QueryBuilder fetchName(){
            setFetchFields("fetchFields","name");
            return this;
        }

        public QueryBuilder excludeName(){
            setFetchFields("excludeFields","name");
            return this;
        }

        public QueryBuilder parentIdBetWeen(Integer parentIdSt,Integer parentIdEd){
            this.parentIdSt = parentIdSt;
            this.parentIdEd = parentIdEd;
            return this;
        }

        public QueryBuilder parentIdGreaterEqThan(Integer parentIdSt){
            this.parentIdSt = parentIdSt;
            return this;
        }
        public QueryBuilder parentIdLessEqThan(Integer parentIdEd){
            this.parentIdEd = parentIdEd;
            return this;
        }


        public QueryBuilder parentId(Integer parentId){
            setParentId(parentId);
            return this;
        }

        public QueryBuilder parentIdList(Integer ... parentId){
            this.parentIdList = solveNullList(parentId);
            return this;
        }

        public QueryBuilder parentIdList(List<Integer> parentId){
            this.parentIdList = parentId;
            return this;
        }

        public QueryBuilder fetchParentId(){
            setFetchFields("fetchFields","parentId");
            return this;
        }

        public QueryBuilder excludeParentId(){
            setFetchFields("excludeFields","parentId");
            return this;
        }

        public QueryBuilder fuzzyPermission (List<String> fuzzyPermission){
            this.fuzzyPermission = fuzzyPermission;
            return this;
        }

        public QueryBuilder fuzzyPermission (String ... fuzzyPermission){
            this.fuzzyPermission = solveNullList(fuzzyPermission);
            return this;
        }

        public QueryBuilder rightFuzzyPermission (List<String> rightFuzzyPermission){
            this.rightFuzzyPermission = rightFuzzyPermission;
            return this;
        }

        public QueryBuilder rightFuzzyPermission (String ... rightFuzzyPermission){
            this.rightFuzzyPermission = solveNullList(rightFuzzyPermission);
            return this;
        }

        public QueryBuilder permission(String permission){
            setPermission(permission);
            return this;
        }

        public QueryBuilder permissionList(String ... permission){
            this.permissionList = solveNullList(permission);
            return this;
        }

        public QueryBuilder permissionList(List<String> permission){
            this.permissionList = permission;
            return this;
        }

        public QueryBuilder fetchPermission(){
            setFetchFields("fetchFields","permission");
            return this;
        }

        public QueryBuilder excludePermission(){
            setFetchFields("excludeFields","permission");
            return this;
        }

        public QueryBuilder fuzzyAuthorityType (List<String> fuzzyAuthorityType){
            this.fuzzyAuthorityType = fuzzyAuthorityType;
            return this;
        }

        public QueryBuilder fuzzyAuthorityType (String ... fuzzyAuthorityType){
            this.fuzzyAuthorityType = solveNullList(fuzzyAuthorityType);
            return this;
        }

        public QueryBuilder rightFuzzyAuthorityType (List<String> rightFuzzyAuthorityType){
            this.rightFuzzyAuthorityType = rightFuzzyAuthorityType;
            return this;
        }

        public QueryBuilder rightFuzzyAuthorityType (String ... rightFuzzyAuthorityType){
            this.rightFuzzyAuthorityType = solveNullList(rightFuzzyAuthorityType);
            return this;
        }

        public QueryBuilder authorityType(String authorityType){
            setAuthorityType(authorityType);
            return this;
        }

        public QueryBuilder authorityTypeList(String ... authorityType){
            this.authorityTypeList = solveNullList(authorityType);
            return this;
        }

        public QueryBuilder authorityTypeList(List<String> authorityType){
            this.authorityTypeList = authorityType;
            return this;
        }

        public QueryBuilder fetchAuthorityType(){
            setFetchFields("fetchFields","authorityType");
            return this;
        }

        public QueryBuilder excludeAuthorityType(){
            setFetchFields("excludeFields","authorityType");
            return this;
        }

        public QueryBuilder fuzzyUrl (List<String> fuzzyUrl){
            this.fuzzyUrl = fuzzyUrl;
            return this;
        }

        public QueryBuilder fuzzyUrl (String ... fuzzyUrl){
            this.fuzzyUrl = solveNullList(fuzzyUrl);
            return this;
        }

        public QueryBuilder rightFuzzyUrl (List<String> rightFuzzyUrl){
            this.rightFuzzyUrl = rightFuzzyUrl;
            return this;
        }

        public QueryBuilder rightFuzzyUrl (String ... rightFuzzyUrl){
            this.rightFuzzyUrl = solveNullList(rightFuzzyUrl);
            return this;
        }

        public QueryBuilder url(String url){
            setUrl(url);
            return this;
        }

        public QueryBuilder urlList(String ... url){
            this.urlList = solveNullList(url);
            return this;
        }

        public QueryBuilder urlList(List<String> url){
            this.urlList = url;
            return this;
        }

        public QueryBuilder fetchUrl(){
            setFetchFields("fetchFields","url");
            return this;
        }

        public QueryBuilder excludeUrl(){
            setFetchFields("excludeFields","url");
            return this;
        }

        public QueryBuilder ynBetWeen(Integer ynSt,Integer ynEd){
            this.ynSt = ynSt;
            this.ynEd = ynEd;
            return this;
        }

        public QueryBuilder ynGreaterEqThan(Integer ynSt){
            this.ynSt = ynSt;
            return this;
        }
        public QueryBuilder ynLessEqThan(Integer ynEd){
            this.ynEd = ynEd;
            return this;
        }


        public QueryBuilder yn(Integer yn){
            setYn(yn);
            return this;
        }

        public QueryBuilder ynList(Integer ... yn){
            this.ynList = solveNullList(yn);
            return this;
        }

        public QueryBuilder ynList(List<Integer> yn){
            this.ynList = yn;
            return this;
        }

        public QueryBuilder fetchYn(){
            setFetchFields("fetchFields","yn");
            return this;
        }

        public QueryBuilder excludeYn(){
            setFetchFields("excludeFields","yn");
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

        public Authority build(){return this;}
    }


    public static class ConditionBuilder{
        private List<Integer> idList;

        public List<Integer> getIdList(){return this.idList;}

        private Integer idSt;

        private Integer idEd;

        public Integer getIdSt(){return this.idSt;}

        public Integer getIdEd(){return this.idEd;}

        private List<String> nameList;

        public List<String> getNameList(){return this.nameList;}


        private List<String> fuzzyName;

        public List<String> getFuzzyName(){return this.fuzzyName;}

        private List<String> rightFuzzyName;

        public List<String> getRightFuzzyName(){return this.rightFuzzyName;}
        private List<Integer> parentIdList;

        public List<Integer> getParentIdList(){return this.parentIdList;}

        private Integer parentIdSt;

        private Integer parentIdEd;

        public Integer getParentIdSt(){return this.parentIdSt;}

        public Integer getParentIdEd(){return this.parentIdEd;}

        private List<String> permissionList;

        public List<String> getPermissionList(){return this.permissionList;}


        private List<String> fuzzyPermission;

        public List<String> getFuzzyPermission(){return this.fuzzyPermission;}

        private List<String> rightFuzzyPermission;

        public List<String> getRightFuzzyPermission(){return this.rightFuzzyPermission;}
        private List<String> authorityTypeList;

        public List<String> getAuthorityTypeList(){return this.authorityTypeList;}


        private List<String> fuzzyAuthorityType;

        public List<String> getFuzzyAuthorityType(){return this.fuzzyAuthorityType;}

        private List<String> rightFuzzyAuthorityType;

        public List<String> getRightFuzzyAuthorityType(){return this.rightFuzzyAuthorityType;}
        private List<String> urlList;

        public List<String> getUrlList(){return this.urlList;}


        private List<String> fuzzyUrl;

        public List<String> getFuzzyUrl(){return this.fuzzyUrl;}

        private List<String> rightFuzzyUrl;

        public List<String> getRightFuzzyUrl(){return this.rightFuzzyUrl;}
        private List<Integer> ynList;

        public List<Integer> getYnList(){return this.ynList;}

        private Integer ynSt;

        private Integer ynEd;

        public Integer getYnSt(){return this.ynSt;}

        public Integer getYnEd(){return this.ynEd;}


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

        public ConditionBuilder fuzzyName (List<String> fuzzyName){
            this.fuzzyName = fuzzyName;
            return this;
        }

        public ConditionBuilder fuzzyName (String ... fuzzyName){
            this.fuzzyName = solveNullList(fuzzyName);
            return this;
        }

        public ConditionBuilder rightFuzzyName (List<String> rightFuzzyName){
            this.rightFuzzyName = rightFuzzyName;
            return this;
        }

        public ConditionBuilder rightFuzzyName (String ... rightFuzzyName){
            this.rightFuzzyName = solveNullList(rightFuzzyName);
            return this;
        }

        public ConditionBuilder nameList(String ... name){
            this.nameList = solveNullList(name);
            return this;
        }

        public ConditionBuilder nameList(List<String> name){
            this.nameList = name;
            return this;
        }

        public ConditionBuilder parentIdBetWeen(Integer parentIdSt,Integer parentIdEd){
            this.parentIdSt = parentIdSt;
            this.parentIdEd = parentIdEd;
            return this;
        }

        public ConditionBuilder parentIdGreaterEqThan(Integer parentIdSt){
            this.parentIdSt = parentIdSt;
            return this;
        }
        public ConditionBuilder parentIdLessEqThan(Integer parentIdEd){
            this.parentIdEd = parentIdEd;
            return this;
        }


        public ConditionBuilder parentIdList(Integer ... parentId){
            this.parentIdList = solveNullList(parentId);
            return this;
        }

        public ConditionBuilder parentIdList(List<Integer> parentId){
            this.parentIdList = parentId;
            return this;
        }

        public ConditionBuilder fuzzyPermission (List<String> fuzzyPermission){
            this.fuzzyPermission = fuzzyPermission;
            return this;
        }

        public ConditionBuilder fuzzyPermission (String ... fuzzyPermission){
            this.fuzzyPermission = solveNullList(fuzzyPermission);
            return this;
        }

        public ConditionBuilder rightFuzzyPermission (List<String> rightFuzzyPermission){
            this.rightFuzzyPermission = rightFuzzyPermission;
            return this;
        }

        public ConditionBuilder rightFuzzyPermission (String ... rightFuzzyPermission){
            this.rightFuzzyPermission = solveNullList(rightFuzzyPermission);
            return this;
        }

        public ConditionBuilder permissionList(String ... permission){
            this.permissionList = solveNullList(permission);
            return this;
        }

        public ConditionBuilder permissionList(List<String> permission){
            this.permissionList = permission;
            return this;
        }

        public ConditionBuilder fuzzyAuthorityType (List<String> fuzzyAuthorityType){
            this.fuzzyAuthorityType = fuzzyAuthorityType;
            return this;
        }

        public ConditionBuilder fuzzyAuthorityType (String ... fuzzyAuthorityType){
            this.fuzzyAuthorityType = solveNullList(fuzzyAuthorityType);
            return this;
        }

        public ConditionBuilder rightFuzzyAuthorityType (List<String> rightFuzzyAuthorityType){
            this.rightFuzzyAuthorityType = rightFuzzyAuthorityType;
            return this;
        }

        public ConditionBuilder rightFuzzyAuthorityType (String ... rightFuzzyAuthorityType){
            this.rightFuzzyAuthorityType = solveNullList(rightFuzzyAuthorityType);
            return this;
        }

        public ConditionBuilder authorityTypeList(String ... authorityType){
            this.authorityTypeList = solveNullList(authorityType);
            return this;
        }

        public ConditionBuilder authorityTypeList(List<String> authorityType){
            this.authorityTypeList = authorityType;
            return this;
        }

        public ConditionBuilder fuzzyUrl (List<String> fuzzyUrl){
            this.fuzzyUrl = fuzzyUrl;
            return this;
        }

        public ConditionBuilder fuzzyUrl (String ... fuzzyUrl){
            this.fuzzyUrl = solveNullList(fuzzyUrl);
            return this;
        }

        public ConditionBuilder rightFuzzyUrl (List<String> rightFuzzyUrl){
            this.rightFuzzyUrl = rightFuzzyUrl;
            return this;
        }

        public ConditionBuilder rightFuzzyUrl (String ... rightFuzzyUrl){
            this.rightFuzzyUrl = solveNullList(rightFuzzyUrl);
            return this;
        }

        public ConditionBuilder urlList(String ... url){
            this.urlList = solveNullList(url);
            return this;
        }

        public ConditionBuilder urlList(List<String> url){
            this.urlList = url;
            return this;
        }

        public ConditionBuilder ynBetWeen(Integer ynSt,Integer ynEd){
            this.ynSt = ynSt;
            this.ynEd = ynEd;
            return this;
        }

        public ConditionBuilder ynGreaterEqThan(Integer ynSt){
            this.ynSt = ynSt;
            return this;
        }
        public ConditionBuilder ynLessEqThan(Integer ynEd){
            this.ynEd = ynEd;
            return this;
        }


        public ConditionBuilder ynList(Integer ... yn){
            this.ynList = solveNullList(yn);
            return this;
        }

        public ConditionBuilder ynList(List<Integer> yn){
            this.ynList = yn;
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

        private Authority obj;

        public Builder(){
            this.obj = new Authority();
        }

        public Builder id(Integer id){
            this.obj.setId(id);
            return this;
        }
        public Builder name(String name){
            this.obj.setName(name);
            return this;
        }
        public Builder parentId(Integer parentId){
            this.obj.setParentId(parentId);
            return this;
        }
        public Builder permission(String permission){
            this.obj.setPermission(permission);
            return this;
        }
        public Builder authorityType(String authorityType){
            this.obj.setAuthorityType(authorityType);
            return this;
        }
        public Builder url(String url){
            this.obj.setUrl(url);
            return this;
        }
        public Builder yn(Integer yn){
            this.obj.setYn(yn);
            return this;
        }
        public Authority build(){return obj;}
    }

    public Authority() {
    }

    public Authority(Integer yn) {
        this.yn = yn;
    }
}
