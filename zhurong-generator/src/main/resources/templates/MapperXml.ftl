<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >

<mapper namespace="${packageName}.${clazzName}">
  <resultMap id="BaseResultMap" type="${clazzPackageName}.${clazzName}">
    <#list columnList as model>
      <#if model.primaryKey ==true>
         <id column="${model.originalName!}"  property="${model.name!}" jdbcType="${model.originalType!}"/>
      <#else>
         <result column="${model.originalName!}"  property="${model.name!}" jdbcType="${model.originalType!}"/>
      </#if>
    </#list>
  </resultMap>

  <sql id="Example_Where_Clause">
    <where>
      <foreach collection="oredCriteria" item="criteria" separator="or">
        <if test="criteria.valid">
          <trim prefix="(" suffix=")" prefixOverrides="and">
            <foreach collection="criteria.criteria" item="criterion">
              <choose>
                <when test="criterion.noValue">
                  and ${r'${'}criterion.condition}
                </when>
                <when test="criterion.singleValue">
                  and ${r'${'}criterion.condition} ${r'#{'}criterion.value}
                </when>
                <when test="criterion.betweenValue">
                  and ${r'${'}criterion.condition} ${r'#{'}criterion.value} and ${r'#{'}criterion.secondValue}
                </when>
                <when test="criterion.listValue">
                  and ${r'${'}criterion.condition}
                  <foreach collection="criterion.value" item="listItem" open="(" close=")" separator=",">
                    ${r'#{'}listItem}
                  </foreach>
                </when>
              </choose>
            </foreach>
          </trim>
        </if>
      </foreach>
    </where>
  </sql>

  <sql id="Update_By_Example_Where_Clause">
    <where>
      <foreach collection="example.oredCriteria" item="criteria" separator="or">
        <if test="criteria.valid">
          <trim prefix="(" suffix=")" prefixOverrides="and">
            <foreach collection="criteria.criteria" item="criterion">
              <choose>
                <when test="criterion.noValue">
                  and ${r'${'}criterion.condition}
                </when>
                <when test="criterion.singleValue">
                  and ${r'${'}criterion.condition} ${r'#{'}criterion.value}
                </when>
                <when test="criterion.betweenValue">
                  and ${r'${'}criterion.condition} ${r'#{'}criterion.value} and ${r'#{'}criterion.secondValue}
                </when>
                <when test="criterion.listValue">
                  and ${r'${'}criterion.condition}
                  <foreach collection="criterion.value" item="listItem" open="(" close=")" separator=",">
                    ${r'#{'}listItem}
                  </foreach>
                </when>
              </choose>
            </foreach>
          </trim>
        </if>
      </foreach>
    </where>
  </sql>

  <sql id="Base_Column_List">
    <#if columnList?exists>
      <#list columnList as model>
        <#if model_has_next!=true>
      ${model.originalName!}
        <#else>
      ${model.originalName!},
        </#if>
      </#list>
    </#if>
  </sql>

  <select id="selectByExample" resultMap="BaseResultMap" parameterType="${packageName}.${clazzName}">
    select
    <if test="distinct">
      distinct
    </if>
    <include refid="Base_Column_List"/>
    from project_data_source
    <if test="_parameter != null">
      <include refid="Example_Where_Clause"/>
    </if>
    <if test="orderByClause != null">
      order by ${r'${'}orderByClause}
    </if>
  </select>

  <#list columnList as model>
    <#if model.primaryKey && model.type ='String'>
  <select id="selectByPrimaryKey" resultMap="BaseResultMap" parameterType="java.lang.String">
    </#if>
    <#if model.primaryKey && model.type ='Integer'>
  <select id="selectByPrimaryKey" resultMap="BaseResultMap" parameterType="java.lang.Integer">
    </#if>
  </#list>
      select
      <include refid="Base_Column_List"/>
      from ${tableName}
      where
      <#list columnList as model>
        <#if model.primaryKey>
          ${model.originalName} =  ${r'#{'} ${model.name},jdbcType=${model.originalType} }
        </#if>
      </#list>
  </select>

    <#list columnList as model>
    <#if model.primaryKey && model.type ='String'>
    <delete id="deleteByPrimaryKey" parameterType="java.lang.String" >
      </#if>
      <#if model.primaryKey && model.type ='Integer'>
      <delete id="deleteByPrimaryKey" parameterType="java.lang.Integer" >
        </#if>
    </#list>
      delete from ${tableName}
      where
      <#list columnList as model>
        <#if model.primaryKey>
          ${model.originalName} = ${r'#{'}${model.name},jdbcType=${model.originalType} }
        </#if>
      </#list>
    </delete>

    <delete id="deleteByExample" parameterType="${packageName}.${clazzName}" >
        delete from ${tableName}
        <if test="_parameter != null" >
          <include refid="Example_Where_Clause" />
        </if>
    </delete>

    <insert id="insert" parameterType="${packageName}.${clazzName}" >
        insert into ${tableName}(
        <#list columnList as model>
          <#if model_has_next!=true>
            ${model.originalName!}
          <#else>
            ${model.originalName!},
          </#if>
        </#list>
        )
        values (
        <#list columnList as model>
          <#if model_has_next!=true>
            ${r'#{'}${model.name},jdbcType=${model.originalType}}
          <#else>
            ${r'#{'}${model.name},jdbcType=${model.originalType}},
          </#if>
        </#list>
        )
    </insert>

    <insert id="insertSelective" parameterType="${packageName}.${clazzName}" >
        insert into ${tableName}
        <trim prefix="(" suffix=")" suffixOverrides="," >

          <#list columnList as model>
            <if test="${model.name} != null" >
              ${model.originalName},
            </if>
          </#list>
        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides="," >
          <#list columnList as model>
            <if test="${model.name} != null" >
            ${r'#{'}${model.name},jdbcType=${model.originalType}},
            </if>
          </#list>
        </trim>
    </insert>

    <select id="countByExample" parameterType="${packageName}.${clazzName}" resultType="java.lang.Integer" >
        select count(*) from ${tableName}
        <if test="_parameter != null" >
          <include refid="Example_Where_Clause" />
        </if>
    </select>

    <update id="updateByExampleSelective" parameterType="map" >
        update ${tableName}
        <set >
          <#list columnList as model>
            <if test="${model.name} != null" >
            ${r'#{'}${model.originalName},jdbcType=${model.originalType}},
            </if>
          </#list>
        </set>
        <if test="_parameter != null" >
          <include refid="Update_By_Example_Where_Clause" />
        </if>
    </update>

    <update id="updateByExample" parameterType="map" >
        update ${tableName}
        set
        <#list columnList as model>
          <#if model_has_next==true>
            ${model.originalName} = ${r'#{'}record.${model.name}},jdbcType=${model.originalType}},
          <#else>
            ${model.originalName} = ${r'#{'}record.${model.name}},jdbcType=${model.originalType}}
          </#if>
        </#list>
        <if test="_parameter != null" >
          <include refid="Update_By_Example_Where_Clause" />
        </if>
    </update>

    <update id="updateByPrimaryKeySelective" parameterType="${packageName}.${clazzName}" >
        update ${tableName}
        <set >
          <#list columnList as model>
            <if test="${model.name} != null" >
            ${r'#{'}${model.originalName},jdbcType=${model.originalType}},
            </if>
          </#list>
        </set>
        where
      <#list columnList as model>
        <#if model.primaryKey>
          ${model.originalName} = ${r'#{'}${model.name},jdbcType=${model.originalType}}
        </#if>
      </#list>
    </update>

    <update id="updateByPrimaryKey" parameterType="${packageName}.${clazzName}" >
        update ${tableName}
        set
        <#list columnList as model>
          <#if model_has_next==true>
            ${model.originalName} = ${r'#{'}record.${model.name}},jdbcType=${model.originalType}},
          <#else>
            ${model.originalName} = ${r'#{'}record.${model.name}},jdbcType=${model.originalType}}
          </#if>
        </#list>
        where
        <#list columnList as model>
          <#if model.primaryKey>
            ${model.originalName} = ${r'#{'}${model.name},jdbcType=${model.originalType}}
          </#if>
        </#list>
    </update>

</mapper>