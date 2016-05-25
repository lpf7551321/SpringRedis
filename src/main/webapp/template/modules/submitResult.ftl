<div>
<#if user?exists || users?exists >
    <table class="table table-bordered" style="align-items: stretch">
        <thead>
        <tr>
            <th></th>
            <th>名字</th>
            <th>年龄</th>
        <tr></tr>
        </thead>
        <tbody>
            <#if users?exists >
                <#list users as item>
                <tr>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.age}</td>
                </tr>
                </#list>
            <#elseif user?exists>
            <tr>
                <td></td>
                <td>${user.name}</td>
                <td>${user.age}</td>
            </tr>
            <#else>
            <p style="align-items: center" class="bg-danger">user is not exists</p>
            </#if>
        </tbody>
    </table>

</#if>

</div>
