//training finished!
<template>
  <div class="training-finished">
    <dm-heading class="element" tag="h1" weight="bold">Training finished!</dm-heading>
    <dm-heading class="element" tag="p" v-if="isEnd" weight="thin">Training completed!</dm-heading>
    <dm-heading class="element" tag="p" v-if="!isEnd" weight="thin">You can continue to train until you answer all
      questions correctly
    </dm-heading>
    <dm-button class="element" id="btnTraining" v-bind:color="trainColor" v-on:click="toTraning">Training</dm-button>
    <dm-heading class="element" tag="h5" weight="thin">{{wrongCount}} questions left</dm-heading>
    <br>
    <!-- 测试 点击bonus直接跳转开始
    <dm-button class="element">Bonus</dm-button>  -->
    <!--    v-if login 结果 -->
    <!--    <dm-button class="element" v-bind:color="startColor" v-on:click="toStart">test-to-start</dm-button>-->
    <dm-button class="element" v-bind:color="startColor" v-on:click="toResult">测试结果</dm-button>
    <br class="element">
    <br class="element">
    <br class="element">
    <br class="element">
    <dm-button class="element" color='black' v-if="!isEnd">Skip Training</dm-button>
    <dm-button class="element" color='black' v-if="isEnd">Finish</dm-button>
  </div>
</template>
<script>
import Vue from 'vue'
import store from '@/store.js'
export default {
  data () {
    return {
      wrongCount: 0,
      isEnd: false
    }
  },
  created () {
    // is first time
    if (this.$store.state.test.isFirstTime) {
      // 计算应该获取的exp
      // 所有的anwser中正确的 一题8经验值
      // 计算第一次正确的题数 待会显示

      for (let x of this.$store.state.questionArray) {
        if (x.queStatus.isAnsRight) {
          this.$store.state.test.firstRightCount += 1
        }
      }
        // 不是第一次了
        this.$store.state.test.isFirstTime = false
    }
    // 查询还有多少个错误的选项
    console.log(this.$store.state.questionArray)
    console.log(this.$store.state.test.isFirstTime)
    console.log(this.$store.state.test.firstRightCount)
    for (let x of this.$store.state.questionArray) {
      if (!x.queStatus.isAnsRight) {
        this.wrongCount++
      }
      // 更新 为答题准备
      if (x.queStatus.isAnswered && x.queStatus.isAnsRight) {
        x.queStatus.isNeedAns = false
      }
      if (x.queStatus.isNeedAns) {
        x.queStatus.isAnsRight = false
        x.queStatus.isAnswered = false
      }
    }
    this.isEnd = this.wrongCount === 0
  },
  methods: {
    toStart () {
      if (this.isEnd) {
        this.$router.push('/training/start')
      }
    },
    toTraning () {
      if (!this.isEnd) {
        this.$router.push('/training/body')
      }
    },
    toResult () {
      if (this.isEnd) {
        this.$router.push('/training/result')
      }
    }
  },
  computed: {
    trainColor: function () {
      if (this.isEnd) {
        return 'black'
      } else {
        return 'blue'
      }
    },
    startColor: function () {
      if (!this.isEnd) {
        return 'black'
      } else {
        return 'blue'
      }
    }
  }
}

</script>
<style>
  html {
    line-height: 1.15;
  }

  .element {
    margin-bottom: 20pt;
  }

  .training-finished {
    border: 5px solid #323e4f;
    border-radius: 5px;
    background-color: rgba(40, 50, 67, .4);
  }

</style>
