// 日期 2019年5月11日
// 作者 hcen
// 界面 主界面 => 显示logo；去答题（登陆后为game）界面；去设置界面；去help界面；去github界面；

<template>
  <div class="home">
    <img alt="logo-pokemon" class="logo" src="../assets/logo-awesome.png"/>
    <Header systemName="公务员"/><br>
    <router-link to="/training/start">
    <dm-button class="btn">开始答题</dm-button><br>
    </router-link>
      <dm-button class="btn" v-on:click="toPerson">个人信息</dm-button><br>
    <router-link to="/setting">
    <dm-button class="btn">&numsp;设置&numsp;</dm-button><br>
    </router-link>
    <router-link to="/about">
    <dm-button class="btn">&numsp;帮助&numsp;</dm-button><br>
    </router-link>
    <a href="https://github.com/hcen1997" target="_blank">
    <dm-button class="btn"> github</dm-button>
    </a>
  </div>
</template>
<script>
// @ is an alias to /src
import Header from '@/components/Header.vue'

export default {
  name: 'home',
  components: {
    Header
  },
  data () {
    return {
    }
  },
  methods:{
    toPerson(){
      if(this.$store.state.person.name!=undefined &&this.$store.state.person.name!=''){
        this.$router.push('/person')
      }else {
        this.$router.push('/login')
      }
    }
  }
}
</script>
<style>
.btn {
  margin-bottom: 20px;
}
.logo {
  width: 100px;
  height: 100px;
}
</style>
