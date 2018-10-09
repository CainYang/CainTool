此项目旨在保存自己为方便工作而写的一些小工具，有看上的请随便拿走

1.OneToAnother<br>在做Spring项目的时候，经常会遇到要把网页的数据保存在数据库中，为了保证系统层次的清晰，数据库类和请求类通常是两个毫无关系的类，然而他们之间的数据常常相差不多,经常需要把请求类的值赋给数据库类，当属性数量较少还好，一旦属性数量很多，
那么就会有大量的重复工作，不停地get,set。<br>
OneToAnother就是将一个类的实例的属性赋值给另一个类的实例的属性的工具，当然这个工具并不是真正意义上的复制，它只是将你需要重复编写的代码自动生成了出来，你还是需要
将代码复制粘贴到你需要的地方。可能有人会问能不能做个运行时自动完成工作的工具，为什么不做有两点原因，第一是我暂时还不知道怎么做，二是能在编译前做好
的工作为什么还要放在运行时去浪费性能来做这个工作呢。<br>
注意：使用此工具需要注意，你的属性的名称必须是驼峰命名法，且开头至少是两个小写字母，另外建议使用IDE自动生成类的get/set方法。即你的方法名看起来应该像是这样的：
getAge(),getOneTwo(),而不能是 getname(),也就是说你的属性名称不能是a,aName这样的。
