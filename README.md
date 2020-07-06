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