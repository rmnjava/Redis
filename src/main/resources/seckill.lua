
--local关键字用于声明局部变量  KEYS[1]代表接收传入的第一个变量
local userid=KEYS[1]; 
local prodid=KEYS[2];
--..代表字符串连接符
local qtkey="sk:"..prodid..":qt";
local usersKey="sk:"..prodid..":usr'; 
--call()调用什么函数，判断用户是否已经抢过
local userExists=redis.call("sismember",usersKey,userid);
--用户已经抢过，就返回2
if tonumber(userExists)==1 then 
	  return 2;
end
--获取商品库存
local num= redis.call("get" ,qtkey);
--商品已经抢完，返回0
if tonumber(num)<=0 then 
	  return 0; 
else 
--  库存自减1
	  redis.call("decr",qtkey);
--将秒杀成功的用户添加进去
	  redis.call("sadd",usersKey,userid);
end
--秒杀成功返回1
return 1;