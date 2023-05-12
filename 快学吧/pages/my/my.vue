<template>
	<view class="page_content">
		<view  class="top_content" >
			<image class="left_min_logo" :src="user.image" @click="chooseImage"></image>
			<navigator url="../personal_data/personal_data" @click="handleMessage(user)" class="right_content">
				<view class="user_name">{{user.nickname}}</view>
				<view class="introduction">{{user.description}}</view>
			</navigator>
		</view>
		<view class="state_content">
			<view class="study_state">
				<view class="day_num">27</view>
				<view class="little_title">连续签到</view>
			</view>
			<view class="study_state">
				<view class="day_num">27</view>
				<view class="little_title">累计签到</view>
			</view>
			<view class="study_state">
				<view class="day_num">27</view>
				<view class="little_title">最大连续</view>
			</view>
		</view>
		<view class="main_content">
			<navigator url="../collection/collection" class="moudle" >
				<view class="right_content">
					<image src="../../static/icon/shoucang1.png"></image>
					<view class="text">我的收藏</view>
				</view>
				<view class="little_icon"> > </view>
			</navigator>
			<navigator url="../note/note" class="moudle">
				<view class="right_content">
					<image src="../../static/icon/biji1.png"></image>
					<view class="text">我的笔记</view>
				</view>
				<view class="little_icon"> > </view>
			</navigator>
			<navigator url="../subscribe/subscribe" class="moudle">
				<view class="right_content">
					<image src="../../static/icon/wode1.png"></image>
					<view class="text">我的订阅</view>
				</view>
				<view class="little_icon"> > </view>
			</navigator>
			<navigator url="../set_up/set_up" class="moudle">
				<view class="right_content">
					<image src="../../static/icon/shezhi1.png"></image>
					<view class="text">设置</view>
				</view>
				<view class="little_icon"> > </view>
			</navigator>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				user:{},
			}
		},
		methods: {
			handleMessage(user){
				//注意：如果用push则不能返回上一个页面
				this.$router.replace({
					path:"../personal_data/personal_data",
					query:{userInfo:user}
				})
			},
			chooseImage(){
				//选择图片
				uni.chooseImage({
					count:1,
					success: (res) => {
						console.log(res)
					}
				});
				
			}
		},
		onLoad() {
			var username=uni.getStorageSync("username");
			var token=uni.getStorageSync("token");
			if(username=="" || token==""){
				uni.navigateTo({
					url:"../login/login"
				})
			}
			this.$request.get("/user/getUserByName",{
				"name":username
			}).then(res=>{
				this.user=res.data;
			});
			
		}
	}
</script>

<style lang="less" scoped>
	
	.top_content{
		background-color: #FFFFFF;
		display: flex;
		margin: 0 0 30rpx;
		padding: 30rpx;
		image{
			margin-right: 30rpx;
			height: 150rpx;
			width: 150rpx;
			border-radius: 50%;
		}
		.right_content{
			.user_name{
				margin-bottom: 20rpx;
				font-size: 18px;
			}
			.introduction{
				font-size: 14px;
				color: #C0C0C0;
			}
		}
	}
	.state_content{
		background-color: #FFFFFF;
		margin: 20rpx;
		display: flex;
		.study_state{
			margin: 20rpx 50rpx;
			text-align: center;
			.day_num{
				color: #4CD964;
			}
			.little_title{
				font-size: 14px;
			}
		}
		
	}
	.main_content{
		.moudle{
			display: flex;
			margin: 2rpx 0;
			padding: 30rpx;
			justify-content: space-between;
			background-color: #FFFFFF;
			.right_content{
				display: flex;
				image{
					margin-right: 30rpx;
					height: 50rpx;
					width: 50rpx;
					border-radius: 50%;
				}
				.text{
				}
			}
			.little_icon{
				
			}
		}
		
	}

</style>
