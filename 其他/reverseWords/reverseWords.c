char * reverseWords(const char * s){
    int point = 0;
    int word_num = 0;
    int word_length=0;
    int limit_word_num = 5000;
    int limit_word_length = 100;
    int length[limit_word_num];
    char *words[limit_word_num];
    for(int i=0;i<limit_word_num;i++){
		words[i] = (char*) malloc(sizeof(char)*limit_word_length);
		memset(words[i],'\0' ,sizeof(char)*limit_word_length);
	}
    char *result = (char*)malloc(sizeof(char)*limit_word_length*limit_word_num);
    memset(result, '\0', sizeof(char)*limit_word_length*limit_word_num);
    int start=0;
    while(true){
        char ch = s[point];
        if(ch == '\0') break;
        if(ch == ' '){
            if(word_length!=0){
                length[word_num] = word_length;
                word_length = 0;
                word_num ++ ;
            }
        }
        else{
            words[word_num][word_length] = ch;
            word_length++;
        }
        point++;
    }
    if(word_length > 0){
		length[word_num] = word_length;
		word_num++;
	}
    for(int i=word_num-1;i>-1;i--){
        strcpy(result+start, words[i]);
        free(words[i]);
        start+=length[i];
        strcpy(result+start, " ");
        start+=1;
    }
    result[start-1] = '\0';
    return result;
}