

<#list datas as ll>
    ${ll}
</#list>

<#list  list as ls>
    <#list ls?keys as itemKey>
        ${ls[itemKey]}
    </#list>
</#list>



<#list systemManager() as ni>
    ${ni}
</#list>
<#-- macro指令自身不打印任何内容，它只是用来创建宏变量，所以就会有一个名为greet的变量。
在<#macro greet>和</#macro>之间的内容（称为宏定义体）当使用它作为指令时将会被执行。
你可以在FTL标记中通过@代替#来使用自定义指令。使用变量名作为指令名。而且，自定义指令的结束标记也是需要的。
 -->
<#macro greet>
<font size="+2">Hello Joe!</font>
</#macro>


<#--
  常用 freemarker标签详解
  <#import "/resource/common_html_front.ftl" as html/> 导入模板 取别名
  <#include "/foot.ftl">
  　　在使用freemarker作为前端页面模板的应用中，会有很多的freemarker模板页面，
  这些ftl会在不同的页面中重复使用，一是为了简化布局的管理，二是可以重复使用一些代码。
　　在freemarker中可以通过以下两种方式来使用已经存在的模板。他们是<#inclue>和<#import>标签。
　　1.<#include> directive
　　该标签的作用是将便签中指定的路径的ftl文件导入到使用标签的ftl文件中，
   包括macro\funtion\variable等所有被引用的ftl内容。被引用的ftl内容会在引用的ftl中重新被渲染最终输出。
    一般用于页面拆分，便于页面重用，如将header和footer分别抽取出来独自成模板，这样在所有返回给前端的page里都可以include这两个模板了。
　　<#include "../../header.ftl"> 将相对路径中的header.ftl文件加载到当前文件中。
    如header.ftl中定义了宏、函数等，在当前文件中可以不加命名空间前缀直接使用。如在header.ftl中
　　定义了<#marco getBranch></macro>,可以在当前文件中直接使用:<@getBranch>...</@getBranch>.
　　 2.<#import> directive
　　该标签的字面意义和include差不多，经常会混淆使用。其含义是将标签中指定的模板中的已定义的宏、函数等导入到当前模板中，
    并在当前文档中指定一个变量作为该模板命名空间，以便当前文档引用。
    与include的区别是该指令不会讲import指定的模板内容渲染到引用的模板的输出中。
　　如：<#import  ”../../service.ftl as service>.其作用是将service.ftl中的定义的各宏、函数、变量、自定义、设置等内容用指定的命名空间名称加以引用。但是当前文档不会将import的模板输出插入到import标签的位置。和<#include>标签一样可以使用相对路径和绝对路径引用外部模板。
　　如：service.ftl中定义的宏如下：<#macro branchService></#macro>,在当前文档中可以这样导入<#import "../../service.ftl" as service> ,service变量作为该文档中使用service中服务的命名空间，调用时应该这样:<@service.branchService >....</@service.branchService>.

      <#assign name=value [in namespacehash]>,
      这个用法用于指定一个名为name的变量,该变量的值为value,
      此外,FreeMarker允许在使用assign指令里增加in子句,
      in子句用于将创建的name变量放入namespacehash命名空间中.
      nested指令
      是可选的，可以在<#macro>和</#macro>之间使用在任何位置和任意次数

 -->