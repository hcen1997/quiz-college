<template>
  <div>
    <blog-header></blog-header>
    <hr/>
    <div>
      <label>
        用户名:
        <input placeholder="请输入用户名" type="text" v-model="loginInfoVo.username"/>
      </label>
      <br/>
      <label>
        密码：
        <input placeholder="请输入密码" type="password" v-model="loginInfoVo.password"/>
      </label>
      <br/>
      <button v-on:click="login">登录</button>
      <br/>
      <label>
        登录验证情况：
        <textarea cols="30" rows="10" v-model="responseResult"></textarea>
      </label>
    </div>
    <hr/>
    <blog-footer></blog-footer>
  </div>
</template>

<script>
import blogHeader from '@/components/common/BlogHeader.vue'
import blogFooter from '@/components/common/BlogFooter.vue'

export default {
  name: 'BlogLogin',
  // blogHeader、blogFooter组件给申明到components里面然后在template里面使用
  components: { blogHeader, blogFooter },
  data () {
    return {
      loginInfoVo: { username: '', password: '' },
      responseResult: []
    }
  },
  methods: {
    login () {
      this.$axios
        .post('/login', {
          username: this.loginInfoVo.username,
          password: this.loginInfoVo.password
        })
        .then(successResponse => {
          this.responseResult = JSON.stringify(successResponse.data)
          if (successResponse.data.code === 200) {
            this.$router.replace({ path: '/index' })
          }
        })
    }
  }
}
</script>
