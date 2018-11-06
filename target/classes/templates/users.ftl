<#ftl encoding='UTF-8'>

<head>
    
    <title>users</title>
</head>
<body>
<div>
<#list model.users as user>
    <tr>
        <td>${user.login}</td>
        <td>${user.email}</td>
    </tr>
</#list>
</div>
</body>
