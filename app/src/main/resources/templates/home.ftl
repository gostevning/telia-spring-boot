<#-- @ftlvariable name="serviceName" type="java.lang.String" -->
<#import "/spring.ftl" as spring />
<#assign xhtmlCompliant = true in spring>
<!DOCTYPE html>
<html>
    <head>
        <title>${serviceName}</title>
    </head>
    <body>

        <h1>${serviceName}</h1>

        <ul>
            <li><a href="<@spring.url '/user' />">User</a></li>
            <li><a href="<@spring.url '/admin' />">Admin Page</a></li>
        </ul>
    </body>
</html>
