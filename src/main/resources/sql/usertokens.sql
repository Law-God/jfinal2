###用户token

#sql("selectUserTokenByAgentAndToken")
  select * from user_tokens where userAgent = ? and token = ?
#end
