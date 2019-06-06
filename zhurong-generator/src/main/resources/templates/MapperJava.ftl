package ${packageName};

import ${clazzPackageName}.${clazzName};
import ${clazzPackageName}.${clazzName}Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ${clazzName}Mapper {
    int countByExample(${clazzName}Example example);

    int deleteByExample(${clazzName}Example example);

    <#list columnList as model>
        <#if model.primaryKey == true>
    int deleteByPrimaryKey(${model.type!} ${model.name!});
        </#if>
    </#list>

    int insert(${clazzName} record);

    int insertSelective(${clazzName} record);

    List<${clazzName}> selectByExample(${clazzName}Example example);

    <#list columnList as model>
        <#if model.primaryKey == true>
    ${clazzName} selectByPrimaryKey(${model.type!} ${model.name!});
        </#if>
    </#list>

    int updateByExampleSelective(@Param("record") ${clazzName} record, @Param("example") ${clazzName}Example example);

    int updateByExample(@Param("record") ${clazzName} record, @Param("example") ${clazzName}Example example);

    int updateByPrimaryKeySelective(${clazzName} record);

    int updateByPrimaryKey(${clazzName} record);
}