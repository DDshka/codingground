#include <iostream>
#include <limits.h>
#include <vector>

#define infinity INT_MAX

using namespace std;

const int numberOfVertexes = 4;
vector<int**> matrixes;
int** wayMatrix = new int*[numberOfVertexes];
int m = 1;

void readMatrix(int** inputArray, const int size)
{
	for (int i = 0; i < size; i++)
		for (int j = 0; j < size; j++)
			cin >> inputArray [i][j];
}

void printMatrix(int** outputArray, const int size)
{
	for (int i = 0; i < size; i++)
	{
		for (int j = 0; j < size; j++)
			cout << outputArray[i][j] << " ";
		cout << endl;
	}
}

void init2Dparray(int** arr, const int& size)
{
	for (int i = 0; i < size; i++)
	{
		arr[i] = new int[size];
		for (int j = 0; j < size; j++)
			arr[i][j] = 0;
	}
}

void initWayMatrix(int** inputArray, int** outputArray, const int& size)
{
	for (int i = 0; i < size; i++)
		for (int j = 0; j < size; j++)
			if (inputArray[i][j] != infinity && inputArray[i][j] != 0) outputArray[i][j] = j;
			else outputArray[i][j] = -1;	//-1 - в связи с тем, что в матрице путей хранятся индексы вершин, в которые можно перейти
											//поэтому 0 означает всякую вершину с индексом 0. -1 означает невозможность перехода.
}

void countMatrix()
{
	if (m > 4) return;
	
	int** temp_matrix = new int*[numberOfVertexes];
	int z = m - 1; //OVER ZRADA - действительный индекс отличается на -1. Придумать нормальное имя переменной или избавиться от "фичи".
	init2Dparray(temp_matrix, numberOfVertexes);

	for (int i = 0; i < numberOfVertexes; i++)
		for (int j = 0; j < numberOfVertexes; j++)
		{
			temp_matrix[i][j] = min(matrixes[m - 1][i][z] + matrixes[m - 1][z][j], matrixes[m - 1][i][j]);
			if (temp_matrix[i][j] < matrixes[m - 1][i][j]) 
				wayMatrix[i][j] = z;
		}
			
	matrixes.push_back(temp_matrix);
	m++;

	countMatrix();
}

//Алгоритм вывода пути согласно методу Флойда.
//Например, если нам надо попасть из v1 в v2, 
//то мы обращаемся к wayMatrix[0][1] и получаем хранящееся значение k. 
//теперь переходим wayMatrix[k][1].
//Выполняем до тех пор пока не дойдём до нашего пункта.
void printWays()
{
	for (int i = 0; i < numberOfVertexes; i++)
		for (int j = 0; j < numberOfVertexes; j++)
		{
			int k = wayMatrix[i][j];
			if (k != -1)
			{
				cout << i + 1;
				while (k != -1)
				{
					cout << " -> " << k + 1;
					k = wayMatrix[k][j];
				}
				cout << endl;
			}
		}
}

int main()
{
	//Пользовательский ввод.
	//int** inputMatrix = new int*[numberOfVertexes];
	//init2Dparray(inputMatrix, numberOfVertexes);
	//readMatrix(inputMatrix, numberOfVertexes);

	int** inputMatrix = new int*[numberOfVertexes];
	inputMatrix[0] = new int[numberOfVertexes] { 0, 1, 2, 1 };
	inputMatrix[1] = new int[numberOfVertexes] { 2, 0, 7, infinity };
	inputMatrix[2] = new int[numberOfVertexes] { 6, 5, 0, 2 };
	inputMatrix[3] = new int[numberOfVertexes] { 1, infinity, 4, 0 };

	matrixes.push_back(inputMatrix);

	init2Dparray(wayMatrix, numberOfVertexes);
	initWayMatrix(inputMatrix, wayMatrix, numberOfVertexes);

	cout << endl;

	printMatrix(wayMatrix, numberOfVertexes);

	cout << endl;

	//f(x)
	//D(m, ij) = min(d(m-1, im) + d(m-1, mj), d(m-1, ij))

	countMatrix();

	for (int i = 0; i <= numberOfVertexes; i++)
	{
		cout << "\tMatrix D" << i << endl << endl;
		printMatrix(matrixes[i], numberOfVertexes);	
		cout  << "________" << endl << endl;
	}

	//printMatrix(wayMatrix, numberOfVertexes);

	cout << endl;

	cout << "All possible ways with the least costs" << endl;

	printWays();

	return 0;
}	
