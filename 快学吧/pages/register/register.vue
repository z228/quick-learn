<template>
	<view>
		<view class="main_content">
			<form @submit="formSubmit">
			    <view class="moudle">
					<view class="right_content"> 
						<view class="label_text" >账号: </view>
						<input name="username" class="text" placeholder="Username"/>
					</view>
			    </view>
				<view class="moudle">
					<view class="right_content">
						<view class="label_text">密码: </view>
						<input password="true" name="password" class="text" placeholder="Password"/>
					</view>
				</view>
				<view class="moudle">
					<view class="right_content">
						<view class="label_text">确认密码: </view>
						<input password="true" name="certianPassword" class="text" placeholder="Password"/>
					</view>
				</view>
				<view class="btn">
					<button form-type="submit">注册</button>
				</view>
			</form>		
		</view>
  </view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			formSubmit: function(e) {
				this.$request.get("/user/register",{
					"user":JSON.stringify(e.detail.value),
				}).then(res=>{
					console.log(res.data)
					if(res.data==true){
						uni.navigateTo({
							url: "../login/login"
						});
					}
				});
			},
		}
	}	
</script>

<style lang="less" scoped>
	.main_content{
		.moudle{
			padding: 20rpx;
			margin: 2rpx 0;
			background-color: #FFFFFF;
			display: flex;
			justify-content: space-between;
			.right_content{
				display: flex;
				.label_text{
					color: #303133;
					width: 80px;
				}
				.text{
					margin-left: 50rpx;
					color: #909399;
				}
			}
		}
		.btn{
			margin: 20rpx 0;
			text-align: center;
			button{
				background-color: #409EFF;
				color: #FFFFFF;
				width: 40%;
			}
		}
	}
</style>