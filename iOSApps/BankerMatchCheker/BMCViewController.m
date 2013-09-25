//
//  BMCViewController.m
//  BankerMatchCheker
//
//  Created by Yuki Toyoshima on 2013/07/28.
//  Copyright (c) 2013年 Yuki Toyoshima. All rights reserved.
//

#import "BMCViewController.h"
#import "BMCAppDelegate.h"
#import "Question.h"

@interface BMCViewController ()

@end

@implementation BMCViewController



- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
    
//    アプリ内で保持しているデリゲートオブジェクをBMCAppDelegateでキャストしてBMCAppDelegate型オブジェクトを生成
    BMCAppDelegate *appDelegate = (BMCAppDelegate *)[[UIApplication sharedApplication]delegate];
//    生成したオブジェクトのメソッドでmanagedObjectContext型オブジェクトを生成
    self.managedObjectContext = [appDelegate managedObjectContext];
    
//    nsfrオブジェクトを生成
//    Persistent Storeからファイルを読み込みManaged Object ContextへManaged Objectとして登録することをフェッチ (fetch) と呼ぶ。各Managed Objectが持つEntity Descriptionを利用して、特定のエンティティをフェッチすることができる。このように、「どのデータを読み出すか」を指示するものが”Fetch Request”（受信要求）(NSFetchRequest) だ。
    NSFetchRequest *fetchRequest = [[NSFetchRequest alloc] init];
//    生成して自身のmanagedObjectContext型メンバに格納していた値をに対して、Questionというキーを使って、そのエンティティ情報を取得する
    NSEntityDescription *entity = [NSEntityDescription entityForName:@"Question" inManagedObjectContext:self.managedObjectContext];
//    nsfrオブジェクトにエンティティをセットする。おそらくその型の値を取得する為。
    [fetchRequest setEntity:entity];
//    nsfc型オブジェクトの情報を元にmanagedObjectContext型オブジェクトがDBに対して処理を実行する
    NSArray *results = [self.managedObjectContext executeFetchRequest:fetchRequest error:nil];
    
    
    
    int cnt = 0;
    for (Question *q in results) {
        NSLog(@"loop中");                                                                        
        NSLog(q.question);
    }
    
    NSLog(@"BMCViewControllerに遷移しました");
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

@end
