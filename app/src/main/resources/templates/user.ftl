<#-- @ftlvariable name="serviceName" type="java.lang.String" -->
<#-- @ftlvariable name="token" type="org.keycloak.representations.IDToken" -->
<#-- @ftlvariable name="principal" type="org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken" -->
<#import "/spring.ftl" as spring />
<#assign xhtmlCompliant = true in spring>
<!DOCTYPE html>
<html>
    <head>
        <title>${serviceName}</title>
    </head>
    <body>
        <header>
            <form action="<@spring.url '/sso/logout' />" method="post">
                <input type="hidden"
                       name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
                <input type="submit" name="submit" value="Logout"/>
            </form>
        </header>

        <h1>${serviceName}</h1>
        <p>User ${principal.name} made this request.</p>

        <h2>My info</h2>
        <ul>
            <#if token.email?has_content><li>Email: ${token.email}</li></#if>
            <#if token.email?has_content><li>Given Name: ${token.givenName}</li></#if>
            <#if token.email?has_content><li>Family Name: ${token.familyName}</li></#if>
        </ul>
    </body>
</html>
