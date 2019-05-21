<template>
    <div>
      <dm-heading tag="h1">登录界面</dm-heading>
      <dm-input v-model="logname" label="用户名称" name="logname"></dm-input>
      <dm-input v-model="logpass" label="用户密码" class="aaa" name="logpass"></dm-input>
      <dm-button v-on:click="dologin" class="aaa">登录</dm-button><br>
      <dm-button v-on:click="doAdd" class="aaa">注册</dm-button><br>
      <router-link to="/">
      <dm-button class="aaa">返回</dm-button><br>
      </router-link>
    </div>
</template>

<script>
import Vue from 'vue'
import store from '@/store.js'
export default {
  name: 'Login',
  data () {
    return {
      logname: '小明',
      logpass: '123'
    }
  },
  methods: {
    dologin () {
      this.$axios
        .post('/person', {
          username: this.logname,
          password: this.logpass
        })
        .then(person => {
          if (person.data != '') {
            let datas = person.data
            // console.log(datas)
            Vue.set(store.state, 'person', datas)

            this.$router.push('/person')
          } else {
            console.log('no user named ' + this.logname)
          }
        })
        .catch(error => {
          this.error = error
        })
    },
    doAdd () {
      this.$axios
        .get('/person/add', {
          params: {
            name: this.logname
          }
        })
        .then(stringtest => {
          console.log(stringtest)
          let datas = stringtest.data
          console.log(datas)
        })
        .catch(error => {
          this.error = error
        })
    }
  }
}
</script>

<style scoped>
.aaa{
  margin-bottom: 20px;
}
</style>
