<template>
	<view>
		<view class="main_video_content">
			<view class="moudle" v-for="(item,inex) in video">
				<video id="myVideo" :src="item.videoAddress"
				        @error="videoErrorCallback" controls></video>
				<view class="text">
					<view class="introduction">{{item.title}}</view>
					<view>
						<image src="../../static/icon/dianzan1.png"></image>
						<span>{{item.likeNum}}</span>
					</view>
				</view>
				
			</view> 
		</view> 
	</view>
</template>

<script>
	export default {
		data() {
			return {
				video:[],
				pageNum:1
			}
		},
		methods: {
			//触底事件
			onReachBottom(){
				//翻译
				this.pageNum=this.pageNum+1;
				this.$request.get("/video/queryAllDesc",{
					"pageNum":this.pageNum
				}).then(res=>{
					this.video.push(...res.data)
				});
			},
			videoErrorCallback: function(e) {
				console.log(e)
				uni.showModal({
					content: "视频资源加载出了问题",
					showCancel: false
				})
			},
		},
		onLoad() {
			this.$request.get("/video/queryAllDesc",{
				"pageNum":this.pageNum
			}).then(res=>{
				this.video=res.data;
				console.log(this.video)
			});
		}
	}
</script>

<style lang="less" scoped>
	
	.main_video_content{
		margin-left: 40rpx;
		.moudle{
			video{
				margin-top: 50rpx;
				height: 400rpx;
				width: 95%;
			}
			.text{
				margin: 0 40rpx;
				display: flex;
				justify-content: space-between;
				.introduction{
					margin-top: 10rpx;
				}
				image{
					margin-right: 30rpx;
					height: 50rpx;
					width: 50rpx;
					border-radius: 50%;
				}
			}
			
		}
	}
</style>
