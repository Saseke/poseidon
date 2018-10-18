<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <@item_show count=1 item_cat_name='手机'>
        <#list item_cat_item_list as item_dto>
        <h1>${item_dto.title}</h1>
        </#list>
    </@item_show>
</body>
</html>