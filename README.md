## 项目技术
> 
> spring boot 2.3 +  mybatis + mybatis-plus


## Restful风格

- 新增：@PostMapping("")
- 修改：@PutMapping("/{id}")
- 查询详情：@GetMapping("/{id}")
- 列表：@GetMapping("")
- 删除：@DeleteMapping("/{id}")

例如：
![avatar](img/restful_demo.jpg)

## API访问
localhost:18088/server/user/add


## 代码生成器
- 执行MpGenerator类里面的main方法（先修改main方法里面的配置）
- 然后将temp文件下面的文件拷贝到对应的目录下面即可