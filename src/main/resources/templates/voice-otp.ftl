Hi ${user.first} ${user.last},
Your otp is: ${otp}.

{<#list 0..otp?length - 1 as i>${otp[i]}<#if i < otp?length - 1> </#if></#list>}
