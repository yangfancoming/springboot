<!DOCTYPE html>

<html lang="en">

<body>
</body>


<h1>
    ${student.name}    <br/>
    ${student.age}    <br/>
    ${student.pet.age}    <br/>
    ${student.pet.nickName}    <br/>
    ${student.getLocation}    <br/>


    <#list student.skill as skill>
        <tr>
        <td> ${student.cityName} </td>
        <td> ${city.description} </td>
        </tr>
    </#list>

123123123
</h1>




</html>