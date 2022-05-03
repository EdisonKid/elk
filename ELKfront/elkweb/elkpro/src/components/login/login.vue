<template>
  <body id="paper">
  <el-form class="login-container" label-position="left" label-width="0px">
    <h3 class="login_title">系统登录</h3>
    <!--    <el-form-item prop="username">
          <el-input type="text" v-model="loginForm.username"
                    auto-complete="off" placeholder="账号"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input type="password" v-model="loginForm.password"
                    auto-complete="off" placeholder="密码"></el-input>
        </el-form-item>-->
    <!-- 用户名 -->
    <el-form-item prop="username">
      <el-input v-model="sname" prefix-icon="el-icon-user"></el-input>
    </el-form-item>
    <!-- 密码 -->
    <el-form-item prop="password">
      <el-input v-model="spwd" prefix-icon="el-icon-lock" type="password"></el-input>
    </el-form-item>
    <!--    <el-checkbox class="login_remember" v-model="checked"
                     label-position="left"><span style="color: #505458">记住密码</span>
        </el-checkbox>-->
    <el-form-item style="width: 100%">
      <el-button type="primary" style="width: 40%;background: #505458;border: none" v-on:click="login">登录</el-button>
      <!--      <router-link to="register"><el-button type="primary" style="width: 40%;background: #505458;border: none">注册</el-button></router-link>-->
    </el-form-item>
  </el-form>
  </body>
</template>
<script>
export default {
  data() {
    return {
      sname: '',
      spwd: '',
      result: ''
    }
  },
  methods: {
    // 登录
    login() {
      var url = "/login"
      var params = {
        'USER_NAME': this.sname,
        'USER_PSD': this.spwd
      }
      this.$http.get(url, {params}).then(res => {
        this.result = res.data
        if (res.data[0] == 200) {
          this.$message.success('登陆成功')
          // this.$router.push('/Studisplay')
          // 传用户名到home.vue
          this.$router.push({
            path: '/index',
            /*query:{
              sname:res.data[1]
            }*/
          })
        } else {
          this.$message.error('登陆失败,用户名或密码错误')
        }
      })
    },
    // 点击注册跳转到注册页面
    /*register(){
      this.$router.push('/register')
    }*/
  }
}
</script>
<style>
#paper {
  background: url("../../images/bg1.jpg") no-repeat;
  background-position: center;
  height: 100%;
  width: 100%;
  background-size: cover;
  position: fixed;
}

body {
  margin: 0;
}

.login-container {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 90px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}

.login_title {
  margin: 0px auto 40px auto;
  text-align: center;
  color: #505458;
}

.login_remember {
  margin: 0px 0px 35px 0px;
  text-align: left;
}
</style>
