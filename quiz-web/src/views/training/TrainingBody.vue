// 内容
// 答题页面 答完默认10道题后跳转到答题结果页面
<template>
  <div class="training-body">
    <div class="question">asdfassfas<br>fasfasdf</div>
    <div class="middle">
        <!-- if in training  time is infinete -->
      <dm-heading tag="h2" id="timmer" >Timmer</dm-heading>
      <dm-button class="ansBtn">Hint</dm-button>
      <dm-heading tag="h2">this/Total</dm-heading>
    </div>
    <div class="middle">
      <dm-button class="ansBtn">Report</dm-button>
      <dm-button class="ansBtn">Info</dm-button>
      <dm-button class="ansBtn" color="black">Finish</dm-button>
    </div>
    <div class="chooise">
        <dm-button class="ansBtn">first ans</dm-button>
        <dm-button class="ansBtn">second ans</dm-button>
        <br>
        <dm-button class="ansBtn">third ans</dm-button>
        <dm-button class="ansBtn">foured ans</dm-button>
        </div>
    <div class="timeup">
        <dm-heading tag="h2">Time is up!</dm-heading>
        <dm-heading tag="p">this is the right answer！</dm-heading>
        <dm-heading tag="p">(press to continue)</dm-heading>
    </div>
    <div class="wrong">
        <dm-heading tag="h2">Wrong Answer</dm-heading>
        <dm-heading tag="small">this is the wrong answar</dm-heading>
        <dm-heading tag="h1">this is the right answer！</dm-heading>
        <dm-heading tag="p">(press to continue)</dm-heading>
    </div>
    <div class="wrong">
        <dm-heading tag="h2">Right Answer</dm-heading>
        <dm-heading tag="h2">here are 9 exp </dm-heading>
        <!-- if in training no xp -->
        <dm-heading tag="h2">this is the right answer！</dm-heading>
        <dm-heading tag="p">(press to continue)</dm-heading>
    </div>
  </div>
</template>
<script>
</script>
<style>
.question{
    border: 5px solid #323e4f;
  border-radius: 5px;
  background-color: rgba(40,50,67,.4);
}
.ansBtn{
    margin-bottom: 20px;
    margin-left: 20px;
    margin-right: 20px;
}
.timeup{
    border: 5px solid #323e4f;
  border-radius: 5px;
  background-color: rgba(40,50,67,.4);
  margin-bottom: 10pt;
}
.wrong{
    border: 5px solid #323e4f;
  border-radius: 5px;
  background-color: rgba(40,50,67,.4);
}
</style>
