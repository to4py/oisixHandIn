//
//  DTYViewController.m
//  DollToYen
//
//  Created by 大津 真 on 2012/11/18.
//  Copyright (c) 2012年 BNN. All rights reserved.
//

#import "DTYViewController.h"

@interface DTYViewController ()

@end

@implementation DTYViewController

+(void)initialize
{
    // キーと初期値のペアの辞書を生成
    NSMutableDictionary *defaultValues = [NSMutableDictionary dictionaryWithCapacity:2];
    // ドルの初期値を10に
    [defaultValues setValue:@"10" forKey:kDoll];
    // レートの初期値を80.5に
    [defaultValues setValue:@"80.5" forKey:kRate];
    
    NSUserDefaults *userDefaults = [NSUserDefaults standardUserDefaults];
    // 初期値を設定
    [userDefaults registerDefaults:defaultValues];
}

- (void)saveDefault
{
    // ドルとレートをユーザーデフォルトに保存
    NSUserDefaults *userDefaults = [NSUserDefaults standardUserDefaults];
    [userDefaults setObject:self.dollText.text forKey:kDoll];	
    [userDefaults setObject:self.rateText.text forKey:kRate]; 	
    [userDefaults synchronize];
}

- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
    self.dollText.delegate = self;
    self.rateText.delegate = self;
    // ユーザーデフォルトの読み込み
    NSUserDefaults *userDefaults = [NSUserDefaults standardUserDefaults];	
    NSString *dollStr = [userDefaults stringForKey:kDoll];
    NSString *rateStr = [userDefaults stringForKey:kRate];
    self.dollText.text = dollStr;
    self.rateText.text = rateStr;
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (IBAction)calc:(id)sender {
    [self.view endEditing:YES];
    double doll = [self.dollText.text doubleValue];
    double rate = [self.rateText.text doubleValue];
    double yen = doll * rate;
    self.yenLabel.text = [NSString stringWithFormat:@"%.2f", yen];
    // ユーザーデフォルトを保存
    [self saveDefault];
}

- (IBAction)backgroundTapped:(id)sender {
    [self.view endEditing:YES];
}

- (BOOL)textFieldShouldReturn:(UITextField *)textField {
    [self.view endEditing:YES];
    return YES;
}
@end
