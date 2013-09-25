//
//  BMCViewController.h
//  BankerMatchCheker
//
//  Created by Yuki Toyoshima on 2013/07/28.
//  Copyright (c) 2013年 Yuki Toyoshima. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <CoreData/CoreData.h>

@interface BMCViewController : UIViewController<NSFetchedResultsControllerDelegate>


//nsmanagedobjectを操作した時にNSFetchedResultsControllerDelegateへ通知する
//インスタンス生成が必要？このインスタンスが通知する？
//どこで使われている？
@property (strong, nonatomic) NSFetchedResultsController *fetchedResultsController;

//データ管理を行うオブジェクト
//なぜインスタンスの生成が必要？
@property (strong, nonatomic) NSManagedObjectContext *managedObjectContext;

@end
