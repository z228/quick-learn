<template>
	<view>
		<!-- 词组 -->
		<view >
			<el-card class="box-card" v-for="(item,index) in collections" :key="item.id">
				<view  @click="handleMessage(item)">
					<view class="title">
						{{item.composition.title}}
					</view>
					<view class="text">
					  {{item.composition.chinese}}
					</view>
			  </view>
			</el-card>			
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				collections:[]
			}
		},
		methods: {
			handleMessage(item){
				let type = item.composition.type;
				if(type == "文章"){
					this.$router.replace({
						path:"../article/article",
						query:{"article":item.composition}
					})
				}else if(type == "翻译"){
					this.$router.replace({
						path:"../translate/translate",
						query:{"translate":item.composition}
					})
				}else if(type=="作文"){
					this.$router.replace({
						path:"../composition_detil/index",
						query:{"composition":item.composition}
					})
				}
			}
		},
		onLoad() {
			this.$request.get("/colletion").then(res=>{
				console.log(res.data)
				this.collections=res.data;
			});
		}
	}
</script>

<style lang="less" scoped>
	page{
			background-color: #F1F1F1;
		}
	.box-card {
		width: 100%;
		margin: 10rpx;
		.title{
			margin-bottom: 20rpx;
			font-weight: bold;
		}
		.text {
			color: #3F536E;
			font-size: 14px;
			display: -webkit-box;
			overflow: hidden;
			text-overflow: ellipsis;
			word-wrap: break-word;
			white-space: normal !important;
			-webkit-line-clamp: 2;
			-webkit-box-orient: vertical;
		}
		
	}
</style>
