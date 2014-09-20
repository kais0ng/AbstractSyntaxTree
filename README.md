AbstractSyntaxTree
==================

A project is intended for parsing C language program and then generating AST of it.

该项目

首先，使用Flex/Bison构建的C语言语法分析器，对C语言数值计算程序进行词法分析、语法分析，
进而检查出该程序代码中的词法错误和语法错误，并输出该C语言程序的AST到txt文件。

然后，用java（反射机制）解析txt文件，重新生成AST文件并输出该C语言程序。 
