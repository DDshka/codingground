#ifndef DFM
#define infinity UINT_MAX
#define INPUT_INFINITY "inf"
#define uint unsigned int

using std::cin;
using std::cout;
using std::endl;
using std::vector;
using std::is_same;

template<typename _type>
static void init2Dparray(_type**& arr, uint _size, _type initializeValue)
{
	arr = new _type*[_size];
	for (uint i = 0; i < _size; i++)
	{
		arr[i] = new _type[_size];
		for (uint j = 0; j < _size; j++)
			arr[i][j] = initializeValue;
	}
}

//OMG VALIDATION
template<typename numericType>
void readMatrix(numericType** &outMatrix, uint &outSize)
{
	outSize = 0;
	char* _size = new char;
	do
	{
		cout << "Enter number of vertexes\t";
		cin >> _size;
		outSize = abs(atoi(_size));
		if (outSize <= 1)
		{
			cout << "Amout of vertexes must be positive number above one.\nTry again\n" << endl;
			cin.clear();
		}
		else
			break;
	} while (true);

	init2Dparray<numericType>(outMatrix, outSize, 0);
	for (uint i = 0; i < outSize; i++)
	{
		for (uint j = 0; j < outSize; j++)
		{
			char* temp_char = new char;
			numericType temp_numeric = 0;
			do
			{
				cout << "D0[" << i + 1 << "][" << j + 1 << "] = ";
				cin >> temp_char;
				temp_numeric = (!strcmp(temp_char, INPUT_INFINITY)) ? infinity : abs(atoi(temp_char));
				if (i == j && temp_numeric != 0)
				{
					cout << "Input is incorrect.\nOne of possible reasons:\n1 - you put zero value to position where i = j;\n2 - something wrong.\nTry one more time;\n" << endl;
					cin.clear();
				}
				else
				{
					outMatrix[i][j] = temp_numeric;
					break;
				}

			} while (true);
		}
		cout << endl;
	}
}

template<typename numericType>
class DantzigFloydMethod
{
	static_assert(std::is_same<numericType, int>::value ||
	std::is_same<numericType, unsigned int>::value ||
	std::is_same<numericType, unsigned short int>::value ||
	std::is_same<numericType, double>::value ||
	std::is_same<numericType, float>::value,
	"Invalid type. Method can work only with numeric types");

public:
	DantzigFloydMethod(numericType** inputMatrix, const uint size)
	{
		_size = size;

		matrixes.push_back(inputMatrix);
		step++;

		initWayMatrix();
		countMatrix();
	}

	//Returns matrix by a number of step. Under index 0 keeps an input matrix (because it is D0)
	numericType** getMatrix(uint stepIndex)
	{
		return (stepIndex >= 0 && stepIndex <= _size) ? matrixes[stepIndex] : nullptr;
	}

	//Returns a way matrix calculated in Floyd`s Method
	int** getWays()
	{
		return wayMatrix;
	}

private:
	vector<numericType**> matrixes;

	const char INPUT_MATRIX_INDEX = 0;
	int** wayMatrix;
	uint step = 0;
	uint _size = 0;

	void initWayMatrix()
	{
		init2Dparray<int>(wayMatrix, _size, -1);
		numericType** inputMatrix = matrixes[INPUT_MATRIX_INDEX];
		for (uint i = 0; i < _size; i++)
		for (uint j = 0; j < _size; j++)
		if (inputMatrix[i][j] != infinity && inputMatrix[i][j] != 0)
			wayMatrix[i][j] = j;
		//else 
		//wayMatrix[i][j] = -1;	//-1 - в связи с тем, что в матрице путей хранятся индексы вершин, в которые можно перейти
		//поэтому 0 означает всякую вершину с индексом 0. -1 означает невозможность перехода.
	}

	//f(x)
	//D(m, ij) = min(d(m-1, im) + d(m-1, mj), d(m-1, ij))
	void countMatrix()
	{
		if (step > _size) return;

		uint pmi = step - 1;	//previous matrix index - may be next time i should give it more reasonable name;
		numericType** previous_matrix = matrixes[pmi];
		numericType** temp_matrix = nullptr;
		init2Dparray<numericType>(temp_matrix, _size, 0);

		for (uint i = 0; i < _size; i++)
		for (uint j = 0; j < _size; j++)
		{
			temp_matrix[i][j] = min(previous_matrix[i][pmi] + previous_matrix[pmi][j], previous_matrix[i][j]);
			if (temp_matrix[i][j] < previous_matrix[i][j])
				wayMatrix[i][j] = pmi;
		}

		matrixes.push_back(temp_matrix);
		step++;

		countMatrix();
	}
};
#endif