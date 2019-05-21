<template>
    <div class="person">
      <div class="info">
        <dm-input v-model="personObj.name"  label="用户名称"
        :readonly="true" name="personName"
        ></dm-input>
        <br>
        <dm-input v-model="levelView"  label="等级"
                  :readonly="true" name="personName"
        ></dm-input><br>
        <dm-progress-bar title="经验值" :progress="personObj.exp"></dm-progress-bar>
        <dm-heading class="element" tag="small">{{personObj.exp%100}}/100exp</dm-heading>
      </div>
      <div class="choice">
        <router-link to="/training/start">
          <dm-button class="btn element">开始答题</dm-button><br>
        </router-link>
        <router-link to="/">
          <dm-button class="btn element">返回主界面</dm-button><br>
        </router-link>
        <dm-button class="btn element" v-on:click="logout">登出</dm-button><br>
      </div>
    </div>
</template>

<script>
import Vue from 'vue'
import store from '@/store.js'
export default {
  name: 'person',
  created () {
    this.personObj = this.$store.state.person
  },
  data () {
    return {
      username: '小明',
      personObj: {
        exp: 20,
        name: '小明test',
        level:0
      }
    }
  },
  computed: {
    progressEXP () {
      let person = this.$store.state.person
      console.log(person)
      return 50
    },
    levelView(){
      return Math.round(this.$store.state.person.exp/100)
    }
  },
  methods:{
    logout(){
      this.$store.state.person = []
      this.$router.push('/')
    }
  }
}
</script>

<style scoped>
  .info{
    border: 5px solid #323e4f;
    border-radius: 5px;
    background-color: rgba(40, 50, 67, 0.4);
    margin-bottom: 20px;
  }
  .choice {
    border: 5px solid #323e4f;
    border-radius: 5px;
    background-color: rgba(40, 50, 67, 0.4);
  }
  .element{
    margin-bottom: 20px;
  }
</style>
