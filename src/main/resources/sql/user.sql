###用户sql

#sql("selectUserById")
  select * from `user` where id = ?
#end

#sql("selectUserByUsernameAndPassword")
  select * from `user` where username = ? and password = ?
#end
