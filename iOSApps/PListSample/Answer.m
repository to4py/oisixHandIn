//
//  Address.m
//  PListSample
//
//  Created by 藤田 泰介 on 11/09/02.
//  Copyright (c) 2012年 Revolution 9. All rights reserved.
//

#import "Answer.h"


@implementation Answer

@synthesize answer;

//疑問：逆？
@synthesize point = _point;

- (id)initWithCoder:(NSCoder *)decoder
{
    self = [super init];
    if (self) {
        answer = [decoder decodeObjectForKey:@"answer"];
        point = [decoder decodeObjectForKey:@"point"];
    }
    return self;
}

- (void)encodeWithCoder:(NSCoder *)encoder
{
    [encoder encodeObject:answer forKey:@"answer"];
    [encoder encodeObject:point forKey:@"point"];
    
}

- (void)dealloc
{
    self.answer = nil;
    
}

-(NSString*)description{
    return [NSString stringWithFormat:@"<%@ :%p ,answer:%@, point:%@>",
            NSStringFromClass([self class]), self, answer, point];
}

@end
