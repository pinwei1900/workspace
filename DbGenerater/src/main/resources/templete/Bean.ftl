import lombok.Data;

@Data
public class ${filename} {
<#list fields as field>
    ${field}
</#list>
}
