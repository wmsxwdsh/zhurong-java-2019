package ${packageName};

<#if columnList?exists>
    <#list columnList as model>
        <#if model.type?? && model.type == "BigDecimal">
import java.math.BigDecimal;
            <#break>
        </#if>
    </#list>
</#if>
<#if columnList?exists>
    <#list columnList as model>
        <#if model.type??>
          <#if (model.type == "Timestamp" || model.type == "Time" || model.type == "Date")>
import java.util.Date;
            <#break>
          </#if>
        </#if>
    </#list>
</#if>

/**
* @description: ${clazzComment}
* @author ${clazzAuthor}
* @date ${clazzDate}
*/
public class ${clazzName} {

    <#if columnList?exists>
        <#list columnList as model>
            <#if model.comment?? && model.comment !="">
    /**
     * ${model.comment}
     */
            </#if>
    private ${model.type!} ${model.name!};

        </#list>
    </#if>

    <#if columnList?exists>
        <#list columnList as model>
    public ${model.type!} get${model.nameUp!}() {
        return this.${model.name!};
    }

    public void set${model.nameUp!}(${model.type!} ${model.name!}) {
        this.${model.name!} = ${model.name!};
    }

        </#list>
    </#if>
}