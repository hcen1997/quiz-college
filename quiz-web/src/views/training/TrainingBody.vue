// 内容
// 答题页面 答完默认10道题后跳转到答题结果页面
<template>
  <div class="training-body">
    <div class="head head-question">
      <dm-textarea :readonly="true" name="questionText" v-model="question.question"></dm-textarea>
    </div>
    <div class="middle-hint" style="margin-top: -19.92px;margin-bottom: -19.92" v-if="!isChoosed&&!isTimeUp">
      <!-- if in training  time is infinete -->
      <h2 id="timmer" style="display: inline-block;margin-right: 10px" tag="h2">Timer</h2>
      <h1 style="display: inline-block">{{timeStr}}</h1>
      <dm-button class="ansBtn">Hint</dm-button>
      <h2 style="display: inline-block" tag="h2">{{comThisIndex}} / {{queTotal}} &numsp;&numsp;</h2>
    </div>
    <div class="middle-info" v-if="isChoosed||isTimeUp">
      <dm-button class="ansBtn">Report</dm-button>
      <dm-button class="ansBtn">Info</dm-button>
      <dm-button class="ansBtn" color="black">Finish</dm-button>
    </div>
    <div class="bottom bottom-chooise" v-if="!isChoosed&&!isTimeUp">
      <dm-button class="ansBtn" id="ans-0" v-on:click="judge">{{ ans[0] }}</dm-button>
      <dm-button class="ansBtn" id="ans-1" v-on:click="judge">{{ ans[1] }}</dm-button>
      <br>
      <dm-button class="ansBtn" id="ans-2" v-on:click="judge">{{ ans[2] }}</dm-button>
      <dm-button class="ansBtn" id="ans-3" v-on:click="judge">{{ ans[3] }}</dm-button>
    </div>
    <div class="bottom bottom-timeup" v-if="isTimeUp" v-on:click="nextQuestion">
      <dm-heading tag="h2">Time is up!</dm-heading>
      <dm-divider color="red" margin="5px auto"></dm-divider>
      <dm-heading tag="h1">{{ question.rightans}}</dm-heading>
      <p style="margin-bottom: 20px"></p>
      <dm-heading tag="p">(press to continue)</dm-heading>
    </div>
    <div class="bottom bottom-wrong" v-if="isChoosed&&!isRightAns" v-on:click="nextQuestion">
      <dm-heading tag="h2">Wrong Answer</dm-heading>
      <dm-divider color="red" margin="5px auto"></dm-divider>
      <dm-heading tag="small">{{selectWrong}}</dm-heading>
      <dm-heading tag="h1">{{ question.rightans}}</dm-heading>
      <p style="margin-bottom: 20px"></p>
      <dm-heading tag="p">(press to continue)</dm-heading>
    </div>
    <div class="bottom bottom-right" v-if="isChoosed&&isRightAns" v-on:click="nextQuestion">
      <dm-heading tag="h2">Right Answer</dm-heading>
      <dm-divider color="green" margin="5px auto"></dm-divider>
      <dm-heading tag="h2">here are 9 exp</dm-heading>
      <!-- if in training no xp -->
      <dm-heading tag="h1">{{ question.rightans}}</dm-heading>
      <p style="margin-bottom: 20px"></p>
      <dm-heading tag="p">(press to continue)</dm-heading>
    </div>
  </div>
</template>
<script>
export default {
  name: 'training-body',
  data () {
    return {
      // questionArray: [] 先显示1个 TODO
      // 测试
      question: {
        difficulty: 1,
        question: 'ok ）',
        answer: 'ans1|ans2|ans3|ans4',
        id: 8,
        category: '常识判断',
        rightans: 'ans1'
      },
      ans: () => {
        return this.question.answer.split('|')
      },
      isChoosed: false,
      isRightAns: false,
      isTimeUp: false,
      timeStr: '0',
      timeInt: 0,
      timeVar: 0,
      queIndex: 0,
      queTotal: 0,
      selectWrong: 'the wrong answar you have selected'
    }
  },
  beforeCreate () {
  },
  created () {
    // 遍历计算出queTotal 页面进入时初始化 之后在finish页面更新
    let queTotal = 0
    // 遍历 queStatus
    let queArray = this.$store.state.questionArray
    for (let i = 0; i < queArray.length; i++) {
      if (queArray[i].queStatus.isNeedAns) {
        queTotal++
      }
    }
    //
    this.queTotal = queTotal // 此处应为唯一更改
    // 页面初始化
    let index = 0
    for (; index < queArray.length; index++) { // 在isNeedAns 中查找没有回答的第一个
      if (queArray[index].queStatus.isNeedAns) {
        if (!queArray[index].queStatus.isAnswered) {
          break
        }
      }
    }
    this.queIndex = index
    this.question = this.$store.state.questionArray[index].queObj
    this.ans = this.question.answer.split('|')
    if(this.$store.state.test.isFirstTime){
      this.startTimer()
    }else{
      this.timeStr='999'
    }
  },
  computed: {
    comThisIndex () {
      // 没有回答的第一个
      let index = 1
      let queArray = this.$store.state.questionArray
      for (let i = 0; i < queArray.length; i++) { // 在isNeedAns 中查找没有回答的第一个
        if (queArray[i].queStatus.isNeedAns) {
          if (queArray[i].queStatus.isAnswered) {
            index++
          }
        }
      }
      //
      return index
    }
  },
  methods: {
    judge (id) {
      // console.log(id) //id是元素的id属性
      let index = id.substr(id.indexOf('-') + 1)
      this.resetTimer()

      // view control
      this.isChoosed = true

      this.$store.state.questionArray[this.queIndex].queStatus.isAnswered = true
      // console.log(this.ans[index])
      if (this.question.rightans === this.ans[index]) {
        // 选择了正确的答案
        this.isRightAns = true
        this.$store.state.questionArray[this.queIndex].queStatus.isAnsRight = true
      } else {
        // 选择了错误的答案
        this.selectWrong = this.ans[index]
        this.isRightAns = false
      }
    },
    nextQuestion () {
      if (this.isTimeUp) {
        this.$store.state.questionArray[this.queIndex].queStatus.isAnswered = true
        this.$store.state.questionArray[this.queIndex].queStatus.isAnsRight = false
      }
      // if(所有问题回答完毕) then 显示finish
      let queArray = this.$store.state.questionArray
      // queArray[0].
      // let queObj = queList.data[i]
      // let queStatus = { isAnswered: false, isAnsRight: false } // 答过了吗? 答对了吗?
      // console.log(this.queIndex, this.queTotal)
      if (this.loopFinish() === 0) {
        // 跳转到finish
        this.resetTimer()
        this.queIndex = 0
        this.$router.push('/training/finished')
      } else {
        // 没有回答的第一个
        let index = 0
        for (let i = 0; i < queArray.length; i++) { // 在isNeedAns 中查找没有回答的第一个
          if (queArray[i].queStatus.isNeedAns) {
            if (!queArray[i].queStatus.isAnswered) {
              index = i
              break
            }
          }
        }
        //
        this.queIndex = index
        this.question = queArray[this.queIndex].queObj
        this.ans = this.question.answer.split('|')
      }
      // 更新view
      this.isChoosed = false
      this.isRightAns = false
      this.isTimeUp = false
      this.resetTimer()
      this.startTimer()
    },
    timerF () { // 定义计时函数
      this.timeInt = this.timeInt + 1 // 秒
      this.timeStr = this.timeInt + ''/* +this.toDubms(this.ms)+"毫秒" */
      if (this.timeStr === '100') { // 这里定义timeout之后的事情
        this.resetTimer()
        this.isTimeUp = true
        // 当前index指向的questionStatus设置为is answerd=ture
        // this.$store.state.questionArray[this.queIndex].queStatus.isAnswered = true
        // this.$store.state.questionArray[this.queIndex].queStatus.isAnsRight = false
      }
    },

    resetTimer () { // 重置
      clearInterval(this.timeVar)
      this.timeInt = 0
      this.timeStr = '0'
    },

    startTimer () { // 开始
      this.timeVar = setInterval(this.timerF, 1000)
    },
    loopFinish () {
      // 没有回答的第一个
      let index = 0
      let queArray = this.$store.state.questionArray
      for (let i = 0; i < queArray.length; i++) { // 在isNeedAns 中查找没有回答的第一个
        if (queArray[i].queStatus.isNeedAns) {
          if (!queArray[i].queStatus.isAnswered) {
            index++
          }
        }
      }
      //
      return index
    }

  },
  components: {}
}

</script>
<style>
  .head {
    border: 5px solid #323e4f;
    border-radius: 5px;
    background-color: rgba(40, 50, 67, .4);
    margin-bottom: 20px;
  }

  .ansBtn {
    margin-bottom: 20px;
    margin-left: 20px;
    margin-right: 20px;
  }

  .bottom {
    border: 5px solid #323e4f;
    border-radius: 5px;
    background-color: rgba(40, 50, 67, .4);
  }

</style>
