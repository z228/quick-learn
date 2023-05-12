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
			<navigator v-if="user.username === 'admin'" url="../user_manage/user_manage" class="moudle">
				<view class="right_content">
<svg t="1683878154382" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2319" width="26" height="26"><path d="M353.28 535.893333a213.333333 213.333333 0 1 0-213.333333-213.333333 213.333333 213.333333 0 0 0 213.333333 213.333333z m0-372.053333a157.866667 157.866667 0 1 1-155.306667 157.44 156.586667 156.586667 0 0 1 155.306667-157.44z m454.4 377.6a153.173333 153.173333 0 1 0-103.68 5.546667 235.52 235.52 0 0 0-122.88 85.333333A331.52 331.52 0 0 0 21.333333 872.96v44.373333H682.666667v-26.88-17.493333a341.333333 341.333333 0 0 0-5.12-59.306667h321.706666v-27.306666a111.786667 111.786667 0 0 0 0-11.946667 236.8 236.8 0 0 0-191.573333-232.96z m-156.586667-142.933333a97.28 97.28 0 1 1 97.28 98.133333 98.133333 98.133333 0 0 1-97.28-98.133333zM77.653333 860.16a275.626667 275.626667 0 0 1 550.4 0z m585.813334-103.68a334.506667 334.506667 0 0 0-42.666667-81.493333 178.346667 178.346667 0 0 1 325.973333 81.493333z" fill="#666666" p-id="2320" data-spm-anchor-id="a313x.7781069.0.i0"></path></svg>					<view class="text">用户管理</view>
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
				console.log(this.user);
			});
			console.log(this.user);
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
