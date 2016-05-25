<#macro common>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="x-ua-compatible" content="IE=edge"/>
    <meta name="viewreport" content="width=device-width initial-scale=1"/>
    <link href="/res/css/bootstrap.min.css" rel="stylesheet"/>
    <script rel="script" src="/res/js/bootstrap.min.js"></script>
    <title>from ftl</title>
</head>
<body>
<#include "../modules/header.ftl"/>
<#if pageStatus?exists && pageStatus==0>
    <#include "../modules/submitForm.ftl"/>
<#elseif pageStatus?exists && pageStatus==2>
    <#include "../modules/submitSearch.ftl"/>
<#elseif pageStatus?exists && pageStatus==1 >
    <#include "../modules/submitResult.ftl"/>
<#else>
</#if>
<#nested>
<#include "../modules/copyright.ftl"/>
<#include "../modules/footer.ftl"/>
</body>

</html>
</#macro>
