//答题结果页面
<template>
  <div class="training-result">
    <dm-heading class="element" tag="h1">Game Completed!</dm-heading>

    <dm-heading class="element" tag="h1">{{bonusThing}}</dm-heading>

    <dm-heading tag="h4">Total questions: {{Total}}</dm-heading>
    <dm-heading tag="h4">Right answers: {{rightCount}}</dm-heading>
    <dm-heading class="element" tag="h4">Hint used: {{hintUsed}}</dm-heading>

    <dm-heading tag="h4">{{baseExp}}</dm-heading>
    <dm-heading class="element" tag="h4">* Medel *</dm-heading>

    <dm-heading tag="h3">Total</dm-heading>
    <dm-heading class="element" tag="h1">{{totalExp}}</dm-heading>

    <dm-progress-bar :progress="expView"></dm-progress-bar>
    <dm-heading class="element" tag="small">{{expViewFinal}}/100exp</dm-heading>

    <dm-heading tag="h1">Game saved</dm-heading>
    <dm-button class="okBtn" v-on:click="toPage">OK</dm-button>
  </div>
</template>
<script>
import Vue from 'vue'
import store from '@/store.js'
export default {
  name: 'TrainingResult',
  created () {
    // 更改本地的数据
    this.$store.state.person.exp += this.$store.state.test.firstRightCount * 8
    // if (this.$store.state.person.exp > 100) {
    //   this.$store.state.person.exp -= 100
    //   this.$store.state.person.level++
    // } 没有level 100经验 1级
    // console.log(this.$store.state.person)
    //
    // 更新exp
    this.$axios
      .post('/person/updateExp', {
        name: this.$store.state.person.name,
        exp: this.$store.state.person.exp
      })
      .then(resultInt => {
        // console.log(resultInt.data)
      })
      .catch(error => {
        // console.log('error')
        // console.log(error)
      })
      // 更新view
    this.baseExp = this.$store.state.test.firstRightCount * 8
    this.totalExp = this.baseExp //* medal
    this.expViewFinal = this.$store.state.person.exp%100
    this.expView = this.$store.state.person.exp%100
    this.rightCounter = this.$store.state.test.firstRightCount
    // test finished refresh
    this.$store.state.test.firstRightCount = 0
    this.$store.state.test.isFirstTime = true
  },
  data () {
    return {
      hintUsed: 0,
      bonusThing: '没有奖励',
      expViewFinal: 0,
      baseExp: 0,
      totalExp: 0,
      expView: 1,
      rightCounter: 0
    }
  },
  computed: {
    Total () {
      // console.log(this.$store.state.questionArray)
      return this.$store.state.questionArray.length
    },
    rightCount () {
      // console.log(this.$store.state.testfirstRightCount.firstRightCount)
      return this.rightCounter
    }
  },
  methods:{
    toPage(){
      if(this.$store.state.person.name!=undefined &&this.$store.state.person.name!=''){
        this.$router.push('/person')
      }else {
        this.$router.push('/training/start')
      }
    }
  }
}
</script>
<style>
.training-result {
  border: 5px solid #323e4f;
  border-radius: 5px;
  background-color: rgba(40, 50, 67, 0.4);
}
</style>
